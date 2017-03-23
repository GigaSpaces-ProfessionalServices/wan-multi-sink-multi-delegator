#!/bin/bash
readonly script_dir="$(dirname $0)"
. ${script_dir}/setenv.sh

readonly GS_ZONE="$1"; shift
readonly gsc_count="$1"; shift
export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS} -Dcom.gs.zones=${GS_ZONE}"
export LOOKUPLOCATORS="$(hostname --ip-address):4174"

echo "Starting 1 GSM, 1 LUS and 1 GSC in '${GS_ZONE}' locally..."
nohup ${JSHOMEDIR}/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 1 gsa.global.gsm 0 gsa.gsm 1 gsa.gsc $gsc_count >${JSHOMEDIR}/logs/start.log 2>&1 &

readonly input_arr=( "$@" )
echo "Starting GSCs in ${GS_ZONE} zone remotely..."
for host_addr in "$@"
do
 ssh ${host_addr} "bash -s" <<EOF
	export JSHOMEDIR="${JSHOMEDIR}"
	export JAVA_HOME="${JAVA_HOME}"
	export GSC_JAVA_OPTIONS="${GSC_JAVA_OPTIONS}"
	export GSM_JAVA_OPTIONS="${GSM_JAVA_OPTIONS}"
	export GSA_JAVA_OPTIONS="${GSA_JAVA_OPTIONS}"
	export LUS_JAVA_OPTIONS="${LUS_JAVA_OPTIONS}"
	export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS}"
	export LOOKUPLOCATORS="${LOOKUPLOCATORS}"
	export NIC_ADDR=\`hostname --ip-address\`
		
	echo "Starting ${gsc_count} GSC on ${host_addr}..."
	nohup ${JSHOMEDIR}/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 0 gsa.global.gsm 0 gsa.gsm 0 gsa.gsc $gsc_count >${JSHOMEDIR}/logs/start.log 2>&1 &
EOF
done
