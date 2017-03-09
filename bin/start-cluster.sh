#!/bin/bash
readonly script_dir="$(dirname $0)"
. ${script_dir}/setenv.sh

readonly GS_ZONE="$1"; shift
export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS} -Dcom.gs.zones=${GS_ZONE}"
export LOOKUPLOCATORS="$(hostname --ip-address):4174"

echo "Starting 1 GSM, 1 LUS and 1 GSC in '${GS_ZONE}' locally..."
nohup ${JSHOMEDIR}/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 1 gsa.global.gsm 0 gsa.gsm 1 gsa.gsc 1 >${JSHOMEDIR}/logs/start.log 2>&1 &

readonly input_arr=( "$@" )
echo "Starting $# GSC(s) in ${GS_ZONE} zone remotely..."
for host_addr in "$@"
do
 ssh ${host_addr} "bash -s" <<EOF
	$(< "${script_dir}/setenv.sh")
	export EXT_JAVA_OPTIONS="${EXT_JAVA_OPTIONS}"
	export LOOKUPLOCATORS="${LOOKUPLOCATORS}"
		
	echo "Starting 1 GSC on ${host_addr}..."
	nohup ${JSHOMEDIR}/bin/gs-agent.sh gsa.global.lus 0 gsa.lus 0 gsa.global.gsm 0 gsa.gsm 0 gsa.gsc 1 >${JSHOMEDIR}/logs/start.log 2>&1 &
EOF
done
