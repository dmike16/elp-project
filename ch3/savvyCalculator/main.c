/*
 * main.c
 *
 *  Created on: 05/ago/2014
 *      Author: dmike
 */

#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <setjmp.h>
#include <ctype.h>
#include <errno.h>
#include <string.h>

#include "parse.h"
#include "value.h"

static enum tokens {
	add='+',
	sub='-',
	par='(',
	numb=NUMBER,
}token;
static jmp_buf onError;
static double number;

void error(const char *fmt,...)
{	va_list ap;

	va_start(ap,fmt);
	vfprintf(stderr,fmt,ap),putc('\n',stderr);
	va_end(ap);
	longjmp(onError,1);
}

static enum tokens scan (const char *buf)
{	static const char *bp;

	if(buf)
		bp=buf;

	while(isspace(*bp))
		++bp;
	if(isdigit(*bp) || *bp == '.')
	{	errno = 0;
		token=NUMBER, number = strtod(bp,(char**)&bp);
		if(errno == ERANGE)
			error("bad value: %s",strerror(errno));
	}
	else
		token = *bp ? *bp++ : 0;
	return token;

}

static void *sum(void);

static void *factor(void)
{	void *result;

	switch (token){
	case '+':
		scan(0);
		return factor();
	case '-':
		scan(0);
		return new(Minus, factor());
	default :
		error("bad factor: '%c' 0x%x",token,token);
		break;
	case NUMBER:
		result = new(Value,number);
		break;
	case '(':
		scan(0);
		result = sum();
		if(token != ')')
			error("expecting )");
		break;
	}
	scan(0);
	return result;
}

static void *product(void)
{	void *result=factor();
	const void *type;

	for(;;)
	{	switch (token){
	case '+':
		type = Add;
		break;
	case '-':
		type = Sub;
		break;
	default:
		return result;
	}
	scan(0);
	result = new(type,result,factor());
	}
}

static void *sum(void)
{	void *result=product();
	const void *type;

	for(;;)
	{	switch (token){
	case '+':
		type = Add;
		break;
	case '-':
		type = Sub;
		break;
	default:
		return result;
	}
	scan(0);
	result = new(type,result,product());
	}
}


int main(void)
{	volatile int errors = 0;
	char buf[BUFSIZ];

	if(setjmp(onError))
		++errors;

	while(gets(buf))
		if(scan(buf))
		{	void *e = sum();
			if(token)
				error("trash after sum");
			process(e);
			delete(e);
		}

return errors>0;
}
