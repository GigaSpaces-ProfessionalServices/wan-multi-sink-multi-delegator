package com.gigaspaces.util.mirror.monitor;

import com.gigaspaces.sync.DataSyncOperation;
import com.gigaspaces.sync.OperationsBatchData;
import com.gigaspaces.sync.TransactionData;
import org.hibernate.SessionFactory;
import org.openspaces.persistency.hibernate.DefaultHibernateSpaceSynchronizationEndpoint;
import org.springframework.beans.factory.annotation.Autowired;

public class Mirror extends DefaultHibernateSpaceSynchronizationEndpoint {

    public Mirror(SessionFactory sessionFactory) {
        super(sessionFactory, null, false, true);
    }

    private boolean debug;
    
    @Autowired
    private IMirrorStats stats;
    
    @Override
    public void onTransactionSynchronization(TransactionData transactionData) {
        if (!isDebug()) {
            super.onTransactionSynchronization(transactionData);
        }
        collectStats(transactionData.getTransactionParticipantDataItems());
    }

    @Override
    public void onOperationsBatchSynchronization(OperationsBatchData batchData) {
        if (!isDebug()) {
            super.onOperationsBatchSynchronization(batchData);
        }
        collectStats(batchData.getBatchDataItems());
    }

    private void collectStats(DataSyncOperation[] bulk) {
        for (DataSyncOperation dataSyncOperation : bulk) {
            if (!isManaged(dataSyncOperation)) {
                continue;
            }
            stats.incrementGlobalCount();
            switch (dataSyncOperation.getDataSyncOperationType()) {
            case REMOVE:
                stats.incrementTakeCount();
                break;
            case WRITE:
                stats.incrementWriteCount();
                break;
            case UPDATE:
                stats.incrementUpdateCount();
                break;
            default:
                break;
            }
        }
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
