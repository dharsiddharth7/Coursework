#include <stdio.h>
#include <string.h>
#include <stdlib.h>

// Problem (1/4)
/******************************************************************************
 * TODO: Print the bits in bitmap as 0s and 1s
 * 
 * Parameters: bitmap -- print the binary representation of this number
 *
 * Return: void 
 *
 * Return Type: void
 *****************************************************************************/
void printBits(unsigned int bitmap)
{
	unsigned int bitmask = 1 << (sizeof(int) * 8 - 1);
	int result;

	while(bitmask != 0) {
		result = bitmap & bitmask;

		if(result == bitmask) {
			printf("1");
		} else {
			printf("0");
		}

		bitmask = bitmask >> 1;
	}
	printf("\n");

	int i = 31;

	for(i = 31; i >= 0; i--) {
		printf("%d", i % 10);
	}

	printf("\n");
}

// Problem (2/4)
/******************************************************************************
 * TODO: Set the ith bit in *bitmap with the value in bitValue (0 or 1)
 * 
 * Parameters: bitmap -- unsigned integer
 *	       i -- index of the bit to be changed
 *             bitValue -- change the ith bit to this value
 *
 * Return: void 
 *
 * Return Type: void
 *****************************************************************************/
void setBitAt( unsigned int *bitmap, int i, int bitValue ) 
{
	unsigned int bitmask = 1 << i;
	
	if(bitValue == 1) {
		*bitmap |= bitmask;
	} else {
		*bitmap ^= bitmask;
	}
}

// Problem (3/4)
/******************************************************************************
 * TODO: Return the bit value (0 or 1) at the ith bit of the bitmap
 * 
 * Parameters: bitmap -- unsigned integer
 *	       i -- index of the bit to be retrieved
 *
 * Return: the ith bit value 
 *
 * Return Type: integer
 *****************************************************************************/
int getBitAt( unsigned int bitmap, unsigned int i) {
	unsigned int bitmask = 1 << i;
	int result = bitmap & bitmask;

	if(bitmask == result) {
		return 1;
	}
	return 0;
}

// Problem (4/4)
/******************************************************************************
 * TODO: Return the number of bits with the value 'bitValue'
 *	 If the bitValue is 0, return the number of 0s. If the bitValue is 1,
 *	 return the number of 1s.
 * 
 * Parameters: bitmap -- unsigned integer
 *	       bitValue -- count how many times this number, either 0 or 1,
 *	       appears in bitmap
 *
 * Return: count of 0s or 1s in bitmap 
 *
 * Return Type: integer
 *****************************************************************************/
int countBits( unsigned int bitmap, unsigned int bitValue) {
	int i = 0;
	int count = 0;

	for(i = 0; i < 32; i++) {
		if(getBitAt(bitmap,i) == bitValue) {
			count++;
		}
	}
	return count;
}

