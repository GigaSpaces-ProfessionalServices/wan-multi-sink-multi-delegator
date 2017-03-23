#!/bin/bash

export GSC_JAVA_OPTIONS="-XX:InitialHeapSize=10g -XX:MaxHeapSize=10g"
$(dirname $0)/start-cluster.sh LN 2 10.8.1.223 10.8.1.239