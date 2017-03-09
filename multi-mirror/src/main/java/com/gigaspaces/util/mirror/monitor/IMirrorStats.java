package com.gigaspaces.util.mirror.monitor;

public interface IMirrorStats {
	public int getWriteCount();
	public int getTakeCount();
	public int getUpdateCount();
	public int getGlobalCount();
	public double getWriteTP();
	public double getTakeTP();
	public double getUpdateTP();
	public long getPartitionRedologSize();
}
