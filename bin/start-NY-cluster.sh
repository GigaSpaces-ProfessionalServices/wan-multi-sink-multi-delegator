#!/bin/bash

export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=20g -XX:MaxHeapSize=20g"
$(dirname $0)/start-mgt-local.sh NY-MONITOR 1
$(dirname $0)/start-gsc-remote.sh NY-FEEDER 1 10.8.1.127
export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=30g -XX:MaxHeapSize=30g"
$(dirname $0)/start-gsc-remote.sh NY-SPACE 1 10.8.1.32 10.8.1.46 10.8.1.47 
export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=10g -XX:MaxHeapSize=10g"
$(dirname $0)/start-gsc-remote.sh NY-MIRROR 3 10.8.1.237
$(dirname $0)/start-gsc-remote.sh NY-WAN 3 10.8.1.211
