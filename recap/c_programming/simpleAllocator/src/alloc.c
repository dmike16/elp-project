/**
 * Name: Simple Allocator
 * Author: dmike16
 * Date: In a strange Friday
 * Implementation: An example of a simple allocator
 *  based on stack-like-structure
 */

#include <stdio.h>
#include "alloc.h"

#define ALLOCSIZE 10000

static char allocbuf[ALLOCSIZE];
static char *allocp  = allocbuf;

char *alloc(int n)
{
	if(allocbuf + ALLOCSIZE - allocp >= n){
		allocp += n;
		return allocp - n;
	}else{
		return NULL;
	}
}

void afree(char *p)
{
	if(p >= allocbuf && p < allocbuf+ALLOCSIZE){
		allocp = p;
	}
}
