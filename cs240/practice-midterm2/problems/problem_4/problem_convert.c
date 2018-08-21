#include <string.h>
#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX_DIGITS 32

// Problem (1/2)
/*****************************************************************************
 * TODO: convert a number from the given base to decimal
 *
 * Parameters: number -- the number you are converting an integer
 *             base   -- the base of the number you are given
 * 
 * Return: The number as an integer
 *
 * Return Type: int
*****************************************************************************/
int ascii(char num) {
	if(num >= '0' && num <= '9') {
		return (int)num - '0';
	} else {
		return (int)num - 'A' + 10;
	}
}

int toInteger(char * number, int base) {
	// Write Your Code Here
	int exp = 1;
	int i = 0;
	int num = 0;
	int length = strlen(number);

	for(i = length - 1; i >= 0; i--) {
		num += ascii(number[i]) * exp;
		exp *= base;
	}
	return num;
}

// Problem (2/2)
/*****************************************************************************
 * TODO: convert a number from the given base to decimal
 *
 * Parameters: number -- the number you are converting a string
 *             base   -- the base you are converting the numebr to
 * 
 * Return: The number as a string in base "base"
 *
 * Return Type: char *
*****************************************************************************/
char * toBase(int number, int base) {
        char digits[36] = 
{'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	int result[100];
	char temp[100];
	int i = 0;

	while(number != 0) {
		result[i] = number % base;
		number /= base;
		i++;
	}

	int j = 0;
	int m = 0;

	for(j = i - 1; j >= 0; j--) {
		temp[m] = digits[result[j]];
		m++;
	}
	temp[m] = '\0';
	return temp;
}
