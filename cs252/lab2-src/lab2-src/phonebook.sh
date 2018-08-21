#!/bin/bash

if [ $# -ne 0 ]; then
	echo "Usage: phonebook"
	exit
fi
DATE=$(date '+%a %b %d %H:%M:%S');
YEAR=$(date '+%Y')
echo "Welcome to MagicPhone!"
printf 'Please enter part or all of a name to search for: '
read -r name
matches=$(egrep -c $name house_dir_tab.txt)
if [[ $(egrep -c $name house_dir_tab.txt) -gt 1 ]]; then
    echo "I found $matches matches"
    echo "You might want to be more specific."
    echo "The first of these matches is:"
    echo "Name: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $1}' )"
    echo "State: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $2}' )"
    echo "Phone: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $4}' )"
    echo "Search complete on $DATE EDT $YEAR"
elif [[ $(egrep -c $name house_dir_tab.txt) -eq 1 ]]; then
    echo "Match found!"
    echo "Name: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $1}' )"
    echo "State: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $2}' )"
    echo "Phone: $(egrep -m 1 $name house_dir_tab.txt | awk -F'\t' '{print $4}' )"
    echo "Search complete on $DATE EDT $YEAR"
elif [[ $(egrep -c $name house_dir_tab.txt) -eq 0 ]]; then
    echo "Sorry, I could not find that person."
fi

