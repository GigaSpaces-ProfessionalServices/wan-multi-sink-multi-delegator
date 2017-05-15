#!/bin/bash

export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=10g -XX:MaxHeapSize=10g"
$(dirname $0)/start-mgt-local.sh LN-WAN 3
export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=15g -XX:MaxHeapSize=15g"
$(dirname $0)/start-gsc-remote.sh LN-SPACE 2 10.8.1.223 10.8.1.239 10.8.1.233 
export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=10g -XX:MaxHeapSize=10g"
$(dirname $0)/start-gsc-remote.sh LN-MIRROR 3 10.8.1.232