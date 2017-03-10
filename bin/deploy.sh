#!/bin/bash

readonly NY_MGT_HOST=10.8.1.107
readonly LN_MGT_HOST=10.8.1.198

readonly script_dir="$(dirname $0)"
. ${script_dir}/setenv.sh

export LOOKUPLOCATORS="${NY_MGT_HOST}:4174"

pu_dir="${script_dir}/../multi-mirror/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name mirror-source1 -properties "embed://mirror.name=mirror-source1;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0;space.host=${NY_MGT_HOST};space.instance.id=1" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name mirror-source2 -properties "embed://mirror.name=mirror-source2;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0;space.host=${NY_MGT_HOST};space.instance.id=2" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name mirror-source3 -properties "embed://mirror.name=mirror-source3;entities.package=com.gigaspaces.gigapro.source;space.name=NYSpace;space.partitions=3;space.backups=0;space.host=${NY_MGT_HOST};space.instance.id=3" ${pu_dir}/mirror.jar

pu_dir="${script_dir}/../source/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY -properties "embed://space.name=NYSpace;space.partitions=3;space.backups=0" ${pu_dir}/source-space.jar

pu_dir="${script_dir}/../delegator/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name delegator1 -properties "embed://delegator.name=NEWYORK_1;sink.name=LONDON_1;source.host=${NY_MGT_HOST};destination.host=${LN_MGT_HOST}" ${pu_dir}/delegator.jar
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name delegator2 -properties "embed://delegator.name=NEWYORK_2;sink.name=LONDON_2;source.host=${NY_MGT_HOST};destination.host=${LN_MGT_HOST}" ${pu_dir}/delegator.jar
$JSHOMEDIR/bin/gs.sh deploy -zones NY -override-name delegator3 -properties "embed://delegator.name=NEWYORK_3;sink.name=LONDON_3;source.host=${NY_MGT_HOST};destination.host=${LN_MGT_HOST}" ${pu_dir}/delegator.jar

export LOOKUPLOCATORS="${LN_MGT_HOST}:4174"

pu_dir="${script_dir}/../multi-mirror/target"
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination1 -properties "embed://mirror.name=mirror-destination1;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=1" ${pu_dir}/mirror.jar 
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination2 -properties "embed://mirror.name=mirror-destination2;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=2" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination3 -properties "embed://mirror.name=mirror-destination3;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=3" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination4 -properties "embed://mirror.name=mirror-destination4;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=4" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination5 -properties "embed://mirror.name=mirror-destination5;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=5" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination6 -properties "embed://mirror.name=mirror-destination6;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=6" ${pu_dir}/mirror.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name mirror-destination7 -properties "embed://mirror.name=mirror-destination7;entities.package=com.gigaspaces.gigapro.destination;space.name=LondonSpace;space.partitions=7;space.backups=0;space.host=${LN_MGT_HOST};space.instance.id=7" ${pu_dir}/mirror.jar

pu_dir="${script_dir}/../destination/target"
$JSHOMEDIR/bin/gs.sh deploy -zones LN -properties "embed://space.name=LondonSpace;space.partitions=7;space.backups=0" ${pu_dir}/destination-space.jar

pu_dir="${script_dir}/../sink/target"
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name sink1 -properties "embed://delegator.name=NEWYORK_1;sink.name=LONDON_1;destination.space=LondonSpace;destination.host=${LN_MGT_HOST}" ${pu_dir}/sink.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name sink2 -properties "embed://delegator.name=NEWYORK_2;sink.name=LONDON_2;destination.space=LondonSpace;destination.host=${LN_MGT_HOST}" ${pu_dir}/sink.jar
$JSHOMEDIR/bin/gs.sh deploy -zones LN -override-name sink3 -properties "embed://delegator.name=NEWYORK_3;sink.name=LONDON_3;destination.space=LondonSpace;destination.host=${LN_MGT_HOST}" ${pu_dir}/sink.jar

export LOOKUPLOCATORS="${NY_MGT_HOST}:4174"
pu_dir="${script_dir}/../multi-wan-feeder/target"
$JSHOMEDIR/bin/gs.sh deploy -zones NY -properties "embed://source.space=NYSpace;source.host=${NY_MGT_HOST}" ${pu_dir}/feeder.jar
