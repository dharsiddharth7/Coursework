#!/bin/bash

FILE=$1
if [ $# -ne 1 ]; then
    echo "Usage: histogram <filename>"
    exit
fi
if [ -r $FILE ]; then
    declare -a array
    array100=""
    array90to100=""
    array80to90=""
    array70to80=""
    array60to70=""
    array50to60=""
    array40to50=""
    array30to40=""
    array20to30=""
    array10to20=""
    array10=""
    array=( $(awk '{print $2}' ./$FILE) )
    numElements=${#array[@]}
    echo "$numElements scores total..."
    total=0
    average=0
    for i in "${array[@]}"
    do
    if [ $i -eq 100 ]; then
        array100+="="
    elif [[ $i -lt 100 && $i -ge 90 ]]; then
        array90to100+="="
    elif [[ $i -lt 90 && $i -ge 80 ]]; then
        array80to90+="="
    elif [[ $i -lt 80 && $i -ge 70 ]]; then
        array70to80+="="
    elif [[ $i -lt 70 && $i -ge 60 ]]; then
        array60to70+="="
    elif [[ $i -lt 60 && $i -ge 50 ]]; then
        array50to60+="="
    elif [[ $i -lt 50 && $i -ge 40 ]]; then
        array40to50+="="
    elif [[ $i -lt 40 && $i -ge 30 ]]; then
        array30to40+="="
    elif [[ $i -lt 30 && $i -ge 20 ]]; then
        array20to30+="="
    elif [[ $i -lt 20 && $i -ge 10 ]]; then
        array10to20+="="
    elif [[ $i -lt 10 ]]; then
        array10+="="
    fi
    let total+=$i
    done
    printf "%s\n" "100: $array100"
    printf "%s\n" " 90: $array90to100"
    printf "%s\n" " 80: $array80to90"
    printf "%s\n" " 70: $array70to80"
    printf "%s\n" " 60: $array60to70"
    printf "%s\n" " 50: $array50to60"
    printf "%s\n" " 40: $array40to50"
    printf "%s\n" " 30: $array30to40"
    printf "%s\n" " 20: $array20to30"
    printf "%s\n" " 10: $array10to20"
    printf "%s\n" "  0: $array10"

    echo "Average: $((total/numElements))"
else
    echo "Error: $FILE is not readable!"
fi
