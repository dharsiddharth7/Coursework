#!/bin/bash
if [ $# -ne 2 ]; then 
	echo "Usage: hailstone <start> <limit>"
	exit
fi
num=$1 
limit=$2
COUNT=0
echo -n "$num "
while [ $COUNT -lt $((limit-1)) ];do 
	if [ $((num % 2)) -eq 0 ];then
		let num=$((num/2))
	elif [ $((num % 2)) -ne 0 ];then
		let num=$(((3*num)+1))
	fi
	echo -n "$num "
	let COUNT=COUNT+1
done 
echo " " 
