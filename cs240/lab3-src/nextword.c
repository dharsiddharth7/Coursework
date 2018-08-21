
#include <stdio.h>
#include <stdlib.h>

//
// Separates the file into words
//

#define MAXWORD 200
char word[MAXWORD];
int wordLength;

// It returns the next word from fd.
// If there are no more more words it returns NULL. 
char * nextword(FILE * fd) {
  	int c = 0;
	
	// While it is not EOF read char
		// While it is not EOF and it is a non-space char
		// store character in word.
		// if char is not in word return word so far.
		//
	// Return null if there are no more words
	wordLength = 0;

	while((c = fgetc(fd)) != EOF) {
		
		
		while((c != ' ') && (c != '\n') && (c != '\t') && (c != '\r')) {
			word[wordLength++] = c;
			c = fgetc(fd);
		}
		word[wordLength] = '\0';

		if (wordLength > 0) {
			
			return word;
		}
		
		if ( c == EOF) {
			return NULL;
		}
	}
	return NULL;
}

