#!/bin/bash

if [ $# -ne 0 ]; then
	echo "Usage: compile"
	exit
fi
 
for f in *.c; do
	echo "C program: $f"
	gcc -Wall -std=c99 $f
	if [ $? -eq 0 ]; then
		echo "Successfully compiled!"
		for i in input*.data; do
			echo "Input file: $i"
			a.out < $i
			if [ $? -eq 0 ]; then
				echo "Run successful."
			elif [ $? -ne 0 ]; then
				echo "Run failed on "$i"."
			fi
		done
	elif [ $? -ne 0 ]; then
		echo "Compilation of "$f" failed!"
	fi
	echo -e 	
done

