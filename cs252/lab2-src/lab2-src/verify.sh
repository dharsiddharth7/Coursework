#!/bin/bash

FILE=$1
REGEX_NAME="^([A-Z][a-z]+, [A-Z][a-z]+( [A-Z].)?)$"
REGEX_ADDRESS="^[0-9]+( [A-Z|0-9]([A-Za-z0-9.])*)+$"
if [ $# -eq 0 ]; then
    echo "Usage: verify <filename>"
    exit
fi

if [ -r $FILE ]; then
    while IFS= read -r line; do
        A=$( echo "$line" |cut -d\; -f1)
        B=$( echo "$line" |cut -d\; -f2)

        if [[ "$A" =~ $REGEX_NAME && "$B" =~ $REGEX_ADDRESS ]]; then
            echo "Data is valid."
        elif [[ "$A" =~ $REGEX_NAME && ! "$B" =~ $REGEX_ADDRESS ]]; then
            echo "Invalid address!"
        elif [[ ! "$A" =~ $REGEX_NAME && "$B" =~ $REGEX_ADDRESS ]]; then
            echo "Invalid name!"
        elif [[ ! "$A" =~ $REGEX_NAME && ! "$B" =~ $REGEX_ADDRESS ]]; then
            echo "Invalid name and address!"
        fi
    done < "$FILE"
else
    echo "Error: $FILE is not readable!"
fi

