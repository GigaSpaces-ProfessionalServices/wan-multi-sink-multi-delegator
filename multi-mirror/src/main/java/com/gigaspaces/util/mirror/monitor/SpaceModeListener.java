package com.gigaspaces.util.mirror.monitor;

import org.openspaces.admin.space.Space;
import org.openspaces.admin.space.events.SpaceModeChangedEvent;
import org.openspaces.admin.space.events.SpaceModeChangedEventListener;

public class SpaceModeListener implements SpaceModeChangedEventListener {

    private Space space;
    private MirrorStats mirrorStats;
    private Integer partitionId;

    public SpaceModeListener(Space space, MirrorStats mirrorStats, Integer partitionId) {
        this.space = space;
        this.mirrorStats = mirrorStats;
        this.partitionId = partitionId;
    }

    @Override
    public void spaceModeChanged(SpaceModeChangedEvent event) {
        String partition_member = event.getSpaceInstance().getInstanceId() + "";
        if (event.getSpaceInstance().getBackupId() != 0) {
            partition_member = partition_member + "_" + event.getSpaceInstance().getBackupId();
        }
        System.out.println("SpaceModeChangedEvent:  Space " + space.getName() + " - Instance " + partition_member + " moved into " + event.getNewMode());
        mirrorStats.setPartition(space.getPartition(partitionId));
    }
}
