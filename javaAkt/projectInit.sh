#!/bin/bash
###################################
## Author: dmike
## email: cip.ollomikele@yahoo.com
## verion: 1.0
## description: create init structure and execute init command to build a project dir structure
###################################

echo -e "Current User \e[1;31m $USER \e[0m | Current SHELL \e[1;31m $SHELL \e[0m"
echo -e 'Today is \c';date
cal
var=bella
echo ${var}
echo "${var} ha ${#var} caratteri"
i='1'
u='2'
let s=i+u
s=$[i+s]
echo $s
array=(1 2 3 4 5 6)

#echo -n Count
#tput sc
#count=0;
#while true;
#do
#	if [ $count -lt 10 ];
#		then let count++;
#		sleep 1;
#		tput rc
#		tput ed
#		echo -n $count;
#	else exit 0;
#	fi
#done

function name(){
	echo $1, $1;
	echo "$@";
	echo "$*";
	return 0;
}
name "b3llaa" "biellea";
exit 0