# wan-multi-sink-multi-delegator

This project is a PoC of [distributed WAN Gateway](https://docs.gigaspaces.com/sbp/wan-gateway-distributed.html) and [distributed mirror](https://docs.gigaspaces.com/sbp/distributed-mirror.html).

***Usage*** 

1. create 2 XAP sites in geographical zones: 'NY' and 'LN'.

copy setenv.sh, start-cluster.sh and start-<zone>-cluster.sh from [bin](./bin) dir to 2 hosts, that will run XAP management node
ssh to 'NewYork' site host and run ```start-NY-cluster.sh``
ssh to 'London' site host and run ```start-London-cluster.sh``

Each XAP cluster should have 1 XAP management node (1 GSM, 1LUS, n GSCs) and 2 compute nodes (n GSCs) after you run the scripts above.

2. create a database in SQL server. 
The JDBC properties can be adjusted in [mirror pu.xml](./multi-mirror/src\main/resources/META-INF/spring/pu.xml) or overridden while deployment. 

3. build
 
```mvn clean package -DskipTests=true```

3. deploy PUs

edit and run [deploy.sh](./bin/deploy.sh)



