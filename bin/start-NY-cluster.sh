#!/bin/bash

export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=20g -XX:MaxHeapSize=20g"
$(dirname $0)/start-cluster.sh NY 1 10.8.1.46 10.8.1.47
