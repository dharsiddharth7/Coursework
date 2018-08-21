#include<string.h>
#include <stdio.h>
#include <errno.h>
#include <stdlib.h>
#include <math.h>

#include "rpn.h"
#include "nextword.h"
#include "stack.h"

double rpn_eval(char * fileName, double x)
{
	FILE *file;
	file = fopen(fileName, "r");
	char * set = malloc(sizeof(char) * 100);
	set = nextword(file);
	int nextPoint = 0;
	double result;
	int point = 1;
	double a;
	double b;

	while (set != NULL && set[0] != EOF)
	{
		if (set[0] == '+')
		{
			a = stack_pop();
			b = stack_pop();
			if (a != 0 && b != 0) 
			{
				result = a + b;
				stack_push(result);
			}
			else {
				point = 0;
			}
		}	
		else if (set[0] == '-' && strlen(set) < 2)
		{
			a = stack_pop();
			b = stack_pop();
			if (a != 0 && b != 0)
			{
				result = b - a;
				stack_push(result);
			}
			else {
				point = 0;
			}
		}
		else if (set[0] == '/')
		{
		 	a = stack_pop();
			b = stack_pop();
			if (a != 0 && b != 0)
			{       
				result = b/a;
				stack_push(result);
			}
		}
		else if (set[0] == '*')
		{
			a = stack_pop();
			b = stack_pop();
			if (a != 0 && b != 0)
			{
				result = a * b;
				stack_push(result);
			}
			else {
				point = 0;
			}
		}
		else if (set[0] == 'c')
		{
			a = stack_pop();
			if (a != 0)
			{
				result = cos(a);
				stack_push(result);
			}
			else {
				point = 0;
			}
		}
		else if (set[0] == 's')
		{
			a = stack_pop();
			if (a != 0)
			{
				result = sin(a);
				stack_push(result);
			}
			else { 
				point = 0;
			}
		}
		else if (set[0] == 'p')
		{
			a = stack_pop();
			b = stack_pop();
			if (a != 0 && b != 0)
			{
				result = pow(b, a);
				stack_push(result);
			}
			else{
				point = 0;
			}
		}
		else if (set[0] == 'e')
		{
			a = stack_pop();
			if (a != 0)
			{
				result = exp(a);
				stack_push(result);
			}
			else {
				point = 0;
			}
		}
		else if (set[0] == 'l')
		{
			a = stack_pop();
			if (a != 0)
			{
				result = log(a);
				stack_push(result);
			}
			else {
				point = 0;
			}
		}
		else if (set[0] == 'x')
		{
			stack_push(x);
			nextPoint = 1;
		}
		else  
		{
			if (strlen(set) > 1)
			{
				stack_push(atof(set));
			}
			else
			{
				stack_push(atoi(set));
			}
		}
		set = nextword(file);
	}
	double varB = stack_pop();
	double varA = stack_pop();
	if (varA != 0)
        {
                printf("Elements remain in the stack\n");
                exit(1);
        }
        else if (!point)
        {
                if(!nextPoint)
                {
                        printf("Stack underflow\n");
                        exit(1);
                }
        }
        return varB;
	
}
