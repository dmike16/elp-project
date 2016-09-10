/**
 * Author: dmike
 * Date: First Sunday of September 2016
 * Scope: Example of chapeter 4 - Function and Program Structure.
 **/

#include <stdio.h>
#include <string.h>

#define MAXLINE 1000

int getln(char line[], int max);
int strindex(char source[],const char searchfor[]);

int main(int argc,char **argv)
{
	if(argc < 2)
	{
		return 0;
	}
	const char* pattern = argv[1];
	if((int)strlen(pattern) > MAXLINE)
	{
		printf("Error input string too long \n");
		return 1;
	}
	char line[MAXLINE];
	while(getln(line,MAXLINE) > 0)
	{
		if(strindex(line,pattern) > 0)
		{
			printf("%s",line);
		}
	}
	return 0;
}

int getln(char s[], int max)
{
	int c,i = 0;
	while(--max > 0 && (c = getchar()) != EOF && c != '\n')
	{
		s[i++] = c;
	}
	if(c == '\n')
	{
		s[i++] = c;
	}
	s[i] = '\0';
	return i;
}

int strindex(char s[],const char t[])
{
	int i,j,k;
	for(i = 0; s[i] != '\0'; i++)
	{
		for(j = i, k = 0; t[k] != '\0' && s[j] == t[k]; j++,k++)
				;
		if(k > 0 && t[k] == '\0')
			return i;
	}
	return -1;
}
