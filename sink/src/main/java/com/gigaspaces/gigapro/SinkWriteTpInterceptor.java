package com.gigaspaces.gigapro;

import com.gigaspaces.sync.DataSyncOperation;
import com.gigaspaces.sync.OperationsBatchData;
import com.gigaspaces.sync.SynchronizationEndpointInterceptor;
import com.gigaspaces.sync.TransactionData;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Svitlana_Pogrebna
 *
 */
public class SinkWriteTpInterceptor extends SynchronizationEndpointInterceptor {

    @Autowired
    private SinkWriteTpStatistics sinkWriteTpStatistics;
    
    @Override
    public void afterTransactionSynchronization(TransactionData transactionData) {
        collectStats(transactionData.getTransactionParticipantDataItems());
    }
    
    @Override
    public void afterOperationsBatchSynchronization(OperationsBatchData batchData) {
        collectStats(batchData.getBatchDataItems());
    }

    private void collectStats(DataSyncOperation[] bulk) {
        for (DataSyncOperation dataSyncOperation : bulk) {
            switch (dataSyncOperation.getDataSyncOperationType()) {
            case WRITE:
                sinkWriteTpStatistics.incrementWriteCounter();
                break;
            default:
                break;
            }
        }
    }
}
