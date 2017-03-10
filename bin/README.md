# Scripts to start XAP cluster
    
    1. setenv.sh
    
    Sets environment variables and JVM options to run XAP components with unicast discovery
    
    2. start-cluster.sh
    
    Starts 1 GSM, 1 LUS and 1 GSC on the local host in specific zone and optionally starts 1 GSC on a remote host via SSH.
    You may need to create SSH config with the connection options. It uses setenv.sh internally.
    
    Look at `start-NY-cluster.sh' or `start-London-cluster.sh` as an example of running it.
    

# Scripts to deploy PUs

    deploy.sh
    
    Deploys all the project PUs in correct order with correct options to XAP data grid running in 'NY' and 'London' zones. It uses setenv.sh to be able to run Gigaspaces CLI.
    