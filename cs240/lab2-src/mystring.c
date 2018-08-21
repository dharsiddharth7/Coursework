
#include <stdlib.h>
#include "mystring.h"

// Type "man string" to see what every function expects.

int mystrlen(char * s) {
	int i = 0;
	for(i = 0; s[i] != '\0'; i++) {
	
	}
	return i;
}

char * mystrcpy(char * dest, char * src) {
	int i = 0;
	for(i = 0; src[i] != '\0'; i++) {
		dest[i] = src[i];
	}
	dest[i] = '\0';
	return dest;
}

char * mystrcat(char * dest, char * src) {
	int i = 0;
	int j = 0;

	for(i = 0; dest[i] != '\0'; i++) { 
	
	}

	for(j = 0;src[j] != '\0'; j++) {
		dest[i] = src[j];
		i++;
	}
	dest[i] = '\0';
	return dest;
}

int mystrcmp(char * s1, char * s2) {
	while(*s1 != '\0' || *s2 != '\0') {
		int d = *s1 - *s2;
		if(d != 0) {
			if(d < 0) {
				return -1;			
			}
			return 1;
		}
		s1++;
		s2++;
	}
	return 0;
}

char * mystrstr(char * hay, char * needle) {
	char * cpyN = needle;
	char * cpyH = hay;

	while(*cpyH != '\0') {
		if(*cpyH == *cpyN) {
			char * foundN = cpyN;
			char * foundH = cpyH;

			while(*foundN != '\0' && *foundH != '\0' && *foundN == *foundH) {
				foundH++;
				foundN++;
			}
			if(*foundN == '\0') {
				return cpyH;
			}
		}
		cpyH++;
	}
	return NULL;
}
char * mystrdup(char * s) {
	char *d = malloc(mystrlen(s) + 1);
	if(d == NULL) {
		return NULL;
	}
	mystrcpy(d,s);
	return d;
        
}

char * mymemcpy(char * dest, char * src, int n)
{
	
	int i;
	
	for(i = 0; i < n; i++) {
		dest[i] = src[i];
	}
	return dest;
}

