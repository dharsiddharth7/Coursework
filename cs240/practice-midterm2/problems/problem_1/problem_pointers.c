#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Problem (1/4)
/******************************************************************************
 * TODO: Print the array.
 *       The format should be (array index)(colon)(array element)(newline) 
 * 
 * Parameters: n -- the number of elements in the array
 *             array -- a double array
 *
 * Return: void 
 *
 * Return Type: void
 *****************************************************************************/
void printArray(int n, double * array) {
	int i = 0;
	double * ptr = array;
	for(i = 0; i < n; i++) {
		printf("%d:%0.6f\n",i,*(ptr + i));
	}
}

// Problem (2/4)
/******************************************************************************
 * TODO: Return the minimum element of array 
 * 
 * Parameters: array -- a double array
 *             n -- the number of elements in the array
 *
 * Return: minimum element in array 
 *
 * Return Type: double
 *****************************************************************************/
double minArray(int n, double * array) {
// Write Your Code Here
	int i = 0;
	double min = *(array + i);

	for(i = 0; i < n; i++) {
		if(*(array + i) < min) {
			min = *(array + i);
		}
	}
	return min;

}

// Problem ( 3/4 ) 
/******************************************************************************
 * TODO: Reverse the given string 'str'. 
 * E.g. reverse_str("smile") should return "elims"
 * 
 * Parameters: str -- The given string to be reversed.
 *
 * Return: A pointer to str, str should be reversed 
 *
 * Return Type: char pointer
 *****************************************************************************/
char * reverse_str (char * str ) {
    // Write Your Code Here
	char * pStart = str;
	char * pEnd = str + strlen(str) - 1;
	int length = strlen(str) - 1;
	char temp;

	while(pStart < pEnd) {
		temp = *pStart;
		*pStart = *pEnd;
		*pEnd = temp;

		pStart++;
		pEnd--;
	}
	return str;
}

// Problem ( 4/4 ) 
/******************************************************************************
 * TODO: Determine if the string str2 is a permutation of str1. A permutation
 * is the rearranging of characters in a different order. 
 * E.g. the string "act" is a permutation of "cat" 
 *
 * Hint: count the occurences of each letter
 * 
 * Parameters: str1 -- The original string
 *	       str2 -- Determine if this string is a permutation of str1 
 *
 * Return: 1 if str2 is a permutation
 *         0 if str2 is not a permutation
 *
 * Return Type: integer
 *****************************************************************************/
int is_permutation ( char * str1, char * str2 ) {
    // Write Your Code Here
    int count1[256] = {0};
    int count2[265] = {0};

    int length1 = strlen(str1);
    int length2 = strlen(str2);

    if(length1 != length2) {
	return 0;
    }

    int i = 0;
    int j = 0;

    for(i = 0; i <= length1 -1; i++) {
	count1[str1[i]]++;
    }

    for(j = 0; j <= length2 -1; j++) {
	count2[str2[j]]++;
    }

    i = 0;

    for(i = 0; i < 256; i++) {
	if(count1[i] != count2[i]) {
		return 0;
	}
    }
    return 1;
}
