package com.gigaspaces.gigapro;

import com.j_spaces.core.IJSpace;
import com.j_spaces.core.cluster.IReplicationFilter;
import com.j_spaces.core.cluster.IReplicationFilterEntry;
import com.j_spaces.core.cluster.ReplicationPolicy;
import org.springframework.beans.factory.annotation.Autowired;

public class ReplicationStatisticsFilter implements IReplicationFilter {

    @Autowired
    private ReplicationStatistics replicationStatistics;
   
    @Override
    public void init(IJSpace space, String arg1, ReplicationPolicy replicationPolicy) {}
    
    @Override
    public void close() {}

    @Override
    public void process(int direction, IReplicationFilterEntry filterEntry, String remoteSpaceMemberName) {
        switch (direction) {
            case IReplicationFilter.FILTER_DIRECTION_INPUT: {
                break;
            }
            case IReplicationFilter.FILTER_DIRECTION_OUTPUT: {
                replicationStatistics.incrementCounter(remoteSpaceMemberName, filterEntry.getOperationType());
                break;
            }
        }
    }
}