#!/bin/bash
readonly script_dir="$(dirname $0)"
. ${script_dir}/setenv.sh

readonly GS_ZONE="$1"; shift
readonly gsc_count="$1"; shift
export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS} -Dcom.gs.zones=${GS_ZONE}"
export LOOKUPLOCATORS="$(hostname --ip-address):4174"

echo "Starting 1 GSM, 1 LUS and ${gsc_count} GSC in '${GS_ZONE}' locally..."
rm -f ${JSHOMEDIR}/logs/*.log
nohup ${JSHOMEDIR}/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 1 gsa.global.gsm 0 gsa.gsm 1 gsa.gsc $gsc_count >${JSHOMEDIR}/logs/start.log 2>&1 &