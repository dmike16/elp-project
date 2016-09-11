#include <stdio.h>
#include "alloc.h"

int main(void)
{
	char *a = alloc(6);
	char *b = alloc(6);
	a = "Hello";
	b = "World",
	printf("Allocate space for : %s\n",a);
	printf("Allocate space for : %s\n",b);
	return 0;
}
