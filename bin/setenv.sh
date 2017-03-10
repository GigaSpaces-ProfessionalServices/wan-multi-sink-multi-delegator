#!/bin/bash
export JSHOMEDIR="/opt/gigaspaces/gigaspaces-xap-premium-10.1.1-ga"
export JAVA_HOME="/opt/java/jdk1.7.0_80"
export PATH="${PATH}:${JAVA_HOME}/bin"
export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS} -Dcom.gs.multicast.enabled=false -Dcom.gs.multicast.discoveryPort=4174"
export NIC_ADDR="$(hostname --ip-address)"
export GSC_JAVA_OPTIONS="-XX:+UseG1GC -XX:+UnlockExperimentalVMOptions -XX:+AggressiveOpts -XX:ConcGCThreads=8 -XX:G1ConcRefinementThreads=4 -XX:G1HeapRegionSize=33554432 -XX:G1HeapWastePercent=40 -XX:G1MaxNewSizePercent=50 -XX:G1MixedGCCountTarget=20 -XX:G1MixedGCLiveThresholdPercent=70 -XX:G1NewSizePercent=25 -XX:G1ReservePercent=10 -XX:+HeapDumpOnOutOfMemoryError -XX:InitialHeapSize=32212254720 -XX:InitiatingHeapOccupancyPercent=50 -XX:MaxGCPauseMillis=1000 -XX:MaxHeapSize=32212254720 -XX:MaxNewSize=6442450944 -XX:MaxPermSize=268435456 -XX:MaxTenuringThreshold=25 -XX:NewSize=6442450944 -XX:ParallelGCThreads=8 -XX:+ParallelRefProcEnabled -XX:PermSize=268435456 -XX:-PrintAdaptiveSizePolicy -XX:-PrintCommandLineFlags -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:-PrintTenuringDistribution -XX:SoftRefLRUPolicyMSPerMB=500 -XX:ThreadStackSize=384 -XX:+UseCompressedOops"
export GSM_JAVA_OPTIONS="-Xms1024m -Xmx1024m"
export GSA_JAVA_OPTIONS="-Xms1024m -Xmx1024m"
export LUS_JAVA_OPTIONS="-Xms1024m -Xmx1024m"