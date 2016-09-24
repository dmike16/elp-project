/**
 * Author: dmike
 * Argument: Exercise 7-1 
 **/

#include <stdio.h>
#include <ctype.h>
#include <string.h>

int main(int argc, char* argv[])
{
	int c;
	printf("Number of argument of %s: %d \n",argv[0],argc);
	if(argc < 2 || strcmp(argv[1],"lower") == 0){
		while((c = getchar()) != EOF)
			putchar(tolower(c));
	}else {
		while((c = getchar()) != EOF)
			putchar(toupper(c));
	}
	return 0;
}
