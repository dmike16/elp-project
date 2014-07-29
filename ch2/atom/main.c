/*
 * main.c
 *
 *  Created on: Jul 29, 2014
 *      Author: dmike
 */

#include <stdio.h>

#include "string.h"
#include "new.h"

int main()
{	void *a=new(String,"a"), *aa=clone(a);
	void *b=new(String,"b");

	printf("sizeOf(a)=%lu\n",sizeOf(a));
	if(differ(a,b))
		puts("ok");
	if(differ(a,aa))
		puts("differ?");
	if(a==aa)
		puts("clone?");
	delete(a),delete(b);
	return 0;
}
