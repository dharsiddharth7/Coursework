/*
 *  CS 24000 First mid-semester exam.
 *   Problem #22
 *
 *  int isPalindrome(char * str)
 *
 *  Arguments:
 *		char * str -- a pointer to a string
 *
 *  Return:
 *		1 if the string is a palindrome, 0 otherwise
 *		
 *  Description:
 *		Given a string of input, return 1 if str is a palindrome, 0 otherwise. A 
 * 		palindrome is a word, phrase, or sequence that reads the same backward as
 *		forward. The function ignores all white spaces (space, tab, newline or 
 * 		carriage return). For example, "madam" and "nurses run" are palindromes.
 */

 /* ======================== Start your edits here =========================== */
 
 /*
  *  NOTE NOTE NOTE NOTE NOTE
  *  You are not allowed to add any other libraries or library includes in addition
  *   to <stdlib.h> other than <math.h> (if you believe you need it).
  */

 #include <stdlib.h>
 /* 
  * Complete the function below for the exam
  */

int length(char * src) {
	int i = 0;
	for(i = 0; src[i] != '\0'; i++);
	return i;
}
int isPalindrome(char * str) {
	int i;
	for(i=0;str[i]!='\0';i++);
	int a =0;
	int len =i;
	int j=len-1;
	for(i=0;i<=len/2;i++){
		if(str[i]==' ' || str[i] == '\t' || str[i] == '\r')
		i++;
		if(str[j]==' ' || str[i] == '\t' || str[i] == '\r')
		j--;
		
		if(str[i]!=str[j--]){
		a=-1;
		}
		
	}
	if(a==0)
		return 1;
	return 0;
}
 /* ======================== End your edits here =========================== */

 /*
 ************************************************************************
  *  Do NOT change any of the lines between here and the end of the file!
 ************************************************************************
  */

#include <stdio.h>
#include <assert.h>

char *Usage = "Usage: %s <string>\n";

int main(int argc, char *argv[])
{
	unsigned int result;
		
	if (argc != 2) 
	{
		fprintf(stderr, Usage, argv[0]);
		exit(1);
	}
	
	result = isPalindrome(argv[1]);

	printf("%s %s a palindrome\n", argv[1], (result == 1) ? "is" : "is not");
	
	return 0;
}
