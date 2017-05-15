#!/bin/bash

readonly NY_MGT_HOST=10.8.1.107
readonly LN_MGT_HOST=10.8.1.198

readonly script_dir="$(dirname $0)"
. ${script_dir}/setenv.sh

export LOOKUPLOCATORS="${NY_MGT_HOST}:4174"

pu_dir="${script_dir}/../multi-mirror/target"

#Multi source mirror
#$JSHOMEDIR/bin/gs.sh deploy -zones NY-MIRROR -override-name mirror-source1 -properties "embed://mirror.name=mirror-source1;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones NY-MIRROR -override-name mirror-source2 -properties "embed://mirror.name=mirror-source2;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones NY-MIRROR -override-name mirror-source3 -properties "embed://mirror.name=mirror-source3;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/mirror.jar

#Single source mirror 
#$JSHOMEDIR/bin/gs.sh deploy -zones NY-MIRROR -override-name mirror-source -properties "embed://mirror.name=mirror-source;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/mirror.jar

pu_dir="${script_dir}/../source/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY-SPACE -properties "embed://space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/source-space.jar

pu_dir="${script_dir}/../delegator/target"
#Multi WAN Gateway
$JSHOMEDIR/bin/gs.sh deploy -zones NY-WAN -cluster total_members=3 -properties "embed://source.host=${NY_MGT_HOST};destination.host=${LN_MGT_HOST}" ${pu_dir}/delegator.jar

#Single WAN Gateway
#$JSHOMEDIR/bin/gs.sh deploy -zones NY-WAN -properties "embed://source.host=${NY_MGT_HOST};destination.host=${LN_MGT_HOST}" ${pu_dir}/delegator.jar

export LOOKUPLOCATORS="${LN_MGT_HOST}:4174"

pu_dir="${script_dir}/../multi-mirror/target"
#Multi destination mirror
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination1 -properties "embed://mirror.name=mirror-destination1;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar 
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination2 -properties "embed://mirror.name=mirror-destination2;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination3 -properties "embed://mirror.name=mirror-destination3;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination4 -properties "embed://mirror.name=mirror-destination4;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination5 -properties "embed://mirror.name=mirror-destination5;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination6 -properties "embed://mirror.name=mirror-destination6;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar

#Single destination mirror 
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-MIRROR -override-name mirror-destination -properties "embed://mirror.name=mirror-destination;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/mirror.jar

pu_dir="${script_dir}/../destination/target"
$JSHOMEDIR/bin/gs.sh deploy -zones LN-SPACE -properties "embed://space.name=LondonSpace;space.partitions=6;space.backups=0" ${pu_dir}/destination-space.jar

pu_dir="${script_dir}/../sink/target"
#Multi WAN Gateway
$JSHOMEDIR/bin/gs.sh deploy -zones LN-WAN -cluster total_members=3 -properties "embed://destination.space=LondonSpace;destination.host=${LN_MGT_HOST}" ${pu_dir}/sink.jar

#Single WAN Gateway
#$JSHOMEDIR/bin/gs.sh deploy -zones LN-WAN -properties "embed://destination.space=LondonSpace;destination.host=${LN_MGT_HOST}" ${pu_dir}/sink.jar

export LOOKUPLOCATORS="${NY_MGT_HOST}:4174"
pu_dir="${script_dir}/../multi-wan-feeder/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY-FEEDER -override-name feeder -properties "embed://source.space=NYSpace;source.host=${NY_MGT_HOST}" ${pu_dir}/feeder.jar

$JSHOMEDIR/bin/gs.sh deploy -zones NY-MONITOR -properties "embed://source.space=NYSpace;source.host=${NY_MGT_HOST}" ${pu_dir}/redo-log-statistics.jar
