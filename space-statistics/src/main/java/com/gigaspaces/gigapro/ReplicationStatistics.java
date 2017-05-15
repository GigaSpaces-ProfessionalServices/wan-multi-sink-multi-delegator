package com.gigaspaces.gigapro;

import com.j_spaces.core.cluster.ReplicationOperationType;
import org.springframework.scheduling.annotation.Scheduled;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.logging.Logger;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class ReplicationStatistics {

    private static final Logger LOG = Logger.getLogger(ReplicationStatistics.class.getName());
    private final ConcurrentMap<String, ConcurrentMap<ReplicationOperationType, Counter>> outputCounterMap = new ConcurrentHashMap<>();

    private final DecimalFormat decimalFormat;

    private final String spaceName;
    private final boolean incoming;
    
    public ReplicationStatistics(String spaceName, boolean incoming) {
        this.spaceName = spaceName;
        this.incoming = incoming;
        decimalFormat = new DecimalFormat();
        decimalFormat.setMaximumFractionDigits(1);
        decimalFormat.setGroupingUsed(false);
    }

    @Scheduled(fixedRateString = "${stats.interval}")
    public void start() {
        for (Entry<String, ConcurrentMap<ReplicationOperationType, Counter>> entry : outputCounterMap.entrySet()) {
            StringBuilder outputBuilder = new StringBuilder();
            outputBuilder.append(new Date()).append(' ').append(spaceName).append(incoming ? "-incoming-replication-source: " : "-outcoming-replication-target: ").append(entry.getKey());
            ConcurrentMap<ReplicationOperationType, Counter> counterOperationMap = entry.getValue();
            for (Entry<ReplicationOperationType, Counter> counterEntry : counterOperationMap.entrySet()) {
                Counter operationCounter = counterEntry.getValue();
                long currTime = System.currentTimeMillis();
                double interval = (double) (currTime - operationCounter.lastTimeStamp) / 1000;
                double operationTp = (operationCounter.count - operationCounter.lastCount) / interval;
                outputBuilder.append(' ').append(counterEntry.getKey().toString().toLowerCase()).append("_tp: ").append(decimalFormat.format(operationTp));
                updateLastCountData(counterOperationMap, counterEntry.getKey(), operationCounter.count, currTime);
            }
            LOG.info(outputBuilder.toString());
        }
    }

    public void incrementCounter(String remoteSpaceMemberName, ReplicationOperationType operationType) {
        ConcurrentMap<ReplicationOperationType, Counter> counterMap = outputCounterMap.get(remoteSpaceMemberName);
        if (counterMap == null) {
            ConcurrentMap<ReplicationOperationType, Counter> emptyMap = new ConcurrentSkipListMap<>();
            counterMap = outputCounterMap.putIfAbsent(remoteSpaceMemberName, emptyMap);
            if (counterMap == null) {
                counterMap = emptyMap;
            }
        }
        incrementCounter(counterMap, operationType);
    }
    
    private static void incrementCounter(ConcurrentMap<ReplicationOperationType, Counter> counterMap, ReplicationOperationType operationType) {
        Counter old = counterMap.get(operationType);
        if (old != null) {
            if (!counterMap.replace(operationType, old, new Counter(old.count + 1, old.lastCount, old.lastTimeStamp))) {
                incrementCounter(counterMap, operationType);
            }
        } else {
            if (counterMap.putIfAbsent(operationType, Counter.one()) != null) {
                incrementCounter(counterMap, operationType);
            }
        }
    }

    private static void updateLastCountData(ConcurrentMap<ReplicationOperationType, Counter> counterMap, ReplicationOperationType operationType, long lastCount, long lastTimeStamp) {
        Counter old = counterMap.get(operationType);
        if (old != null) {
            if (!counterMap.replace(operationType, old, new Counter(old.count, lastCount, lastTimeStamp))) {
                updateLastCountData(counterMap, operationType, lastCount, lastTimeStamp);
            }
        } else {
            if (counterMap.putIfAbsent(operationType, Counter.one()) != null) {
                updateLastCountData(counterMap, operationType, lastCount, lastTimeStamp);
            }
        }
    }

    private static class Counter {

        private final long count;
        private final long lastCount;
        private final long lastTimeStamp;

        public Counter(long count, long lastCount, long lastTimeStamp) {
            this.count = count;
            this.lastCount = lastCount;
            this.lastTimeStamp = lastTimeStamp;
        }

        public static Counter one() {
            return new Counter(1, 0, 0);
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + (int) (count ^ (count >>> 32));
            result = prime * result + (int) (lastCount ^ (lastCount >>> 32));
            result = prime * result + (int) (lastTimeStamp ^ (lastTimeStamp >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            Counter other = (Counter) obj;
            if (count != other.count) {
                return false;
            }
            return lastCount != other.lastCount ? false : lastTimeStamp == other.lastTimeStamp;
        }
    }
}
