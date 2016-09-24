#include <stdio.h>
#include <string.h>
#include "alloc.h"

int main(void)
{
	char *a = alloc(6);
	char *b = alloc(6);
	strcpy(a,"Hello");
	strcpy(b,"World");
	printf("Allocate space for : %s\n",a);
	printf("Allocate space for : %s\n",b);
	afree(b);
	afree(a);
	return 0;
}
