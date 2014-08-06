/*
 * value.c
 *
 *  Created on: 05/ago/2014
 *      Author: dmike
 */

#include <malloc.h>
#include <stdarg.h>
#include <assert.h>

#include "value.h"

struct Type {
	char *name;
	char rank,rpar;
	void *(*new)(va_list ap);
	double (*exec)(const void *tree,int rank,int par);
	void (*delete)(void *tree);
};

struct Bin {
	const void *type;
	void *left,*right;
};

struct Unary {
	const void *type;
	void *center;
};

struct Val {
	const void *type;
	double value;
};

static void *mkVal (va_list ap)
{	struct Val *node = malloc(sizeof(struct Val));

	assert(node);
	node->value = va_arg(ap,double);
	return node;
}


static void *mkBin (va_list ap)
{	struct Bin *node = malloc(sizeof(struct Bin));

	assert(node);

	typedef void* voids;
	node ->left = va_arg(ap,voids);
	node ->right = va_arg(ap,voids);
	return node;

}

static void *mkUnary (va_list ap)
{	struct Unary *node = malloc(sizeof(struct Unary));

	assert(node);

	typedef void* voids;
	node->center = va_arg(ap,voids);
	return node;

}

static void freeBin (void *tree)
{
	delete(((struct Bin *)tree)->left);
	delete(((struct Bin *)tree)->right);
	free(tree);
}

static void freeUnary (void *tree)
{
	delete(((struct Unary *)tree)->center);
	free(tree);
}

static double exec (const void *tree,int rank,int par)
{
	assert(tree && (struct Type**)tree
			&& (*(struct Type **)tree)->exec);

	return (*(struct Type **)tree)->exec(tree,rank,par);
}

static double doVal (const void *tree,int rank,int par)
{
	printf(" %g",((struct Val*)tree)->value);
	return ((struct Val*)tree)->value;
}


static double doAdd (const void *tree,int rank,int par)
{
	const struct Type *type = *(struct Type**)tree;

	par = type->rank<rank || (par && type->rank == rank);
	if(par)putchar('(');
	double a=exec(((struct Bin*)tree)->left,type->rank,0);

	printf(" %s",type->name);

	double b=exec(((struct Bin*)tree)->right,type->rank,type->rpar);

	if(par)putchar(')');

	return a+b;
}

static double doSub (const void *tree,int rank,int par)
{
	const struct Type *type = *(struct Type**)tree;

	par = type->rank<rank || (par && type->rank == rank);
	if(par)putchar('(');
	double a=exec(((struct Bin*)tree)->left,type->rank,0);

	printf(" %s",type->name);

	double b=exec(((struct Bin*)tree)->right,type->rank,type->rpar);

	if(par)putchar(')');

	return a-b;
}

static double doUnary (const void *tree,int rank,int par)
{
	const struct Type *type = *(struct Type**)tree;

	par = type->rank<rank || (par && type->rank == rank);
	if(par)putchar('(');
	printf(" -");

	double a=exec(((struct Unary*)tree)->center,type->rank,type->rpar);

	if(par)putchar(')');

	return -a;
}

static struct Type _Value = {"",0,0,mkVal,doVal,free};
static struct Type _Add = {"+",1,0,mkBin,doAdd,freeBin};
static struct Type _Sub = {"-",1,1,mkBin,doSub,freeBin};
static struct Type _Minus ={"",2,1,mkUnary,doUnary,freeUnary};

const void *Value = &_Value;
const void *Add = &_Add;
const void *Sub = &_Sub;
const void *Minus = &_Minus;

void *new (const void *type,...)
{	va_list ap;
	void *result;

	assert(type && ((struct Type *)type)->new);

	va_start(ap, type);
	result = ((struct Type *)type)->new(ap);
	*(const struct Type **)result = type;
	va_end(ap);
	return result;
}

void delete (void *tree)
{
	assert(tree && *(struct Type **)tree
			&& (*(struct Type **)tree)->delete);

	(*(struct Type **)tree)->delete(tree);
}

void process (const void *tree)
{
	printf("\t= %g\n",exec(tree,0,0));
}
