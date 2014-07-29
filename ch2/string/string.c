/*
 * string.c
 *
 *  Created on: Jul 29, 2014
 *      Author: dmike
 */

#include <stdarg.h>
#include <assert.h>
#include <malloc.h>
#include <string.h>

#include "new.h"
#include "string.h"

struct Class {
	size_t size;
	void *(*ctor)(void *self,va_list *app);
	void *(*dtor)(void *self);
	void *(*clone)(const void *self);
	int (*differ)(const void *self, const void *b);
};

struct String {
	const void *class;
	char *text;
};

struct Set {
	const void *class;
	unsigned count;
};

static void *String_ctor(void *_self,va_list *app)
{	struct String *self=_self;
	const char *text = va_arg(*app,const char *);

	self->text=malloc(strlen(text)+1);
	assert(self->text);
	strcpy(self->text,text);
	return self;
}

static void *String_dtor(void *_self)
{	struct String *self = _self;

	free(self->text),self->text=0;
	return self;

}

static void *String_clone(const void *_self)
{	const struct String *self = _self;

	return new(String,self->text);
}

static int String_differ(const void *_self, const void *_b)
{	const struct String *self =_self;
	const struct String *b = _b;

	if(self==b)
		return 0;
	if(!b || b->class != String)
		return 1;

	return strcmp(self->text,b->text);

}

static const struct Class _String = {
		sizeof(struct String),
		String_ctor, String_dtor,
		String_clone, String_differ
};

const void *String = &_String;

void *new (const void *_class, ...)
{	const struct Class *class = _class;
	void *p = calloc(1,class->size);

	assert(p);
	*(const struct Class **) p = class;

	if(class->ctor)
	{	va_list ap;

		va_start(ap,_class);
		p = class->ctor(p, &ap);
		va_end(ap);
	}

	return p;
}

void delete (void *self)
		{	const struct Class **cp = self;

			if(self && *cp && (*cp)->dtor)
				self = (*cp)->dtor(self);
			free(self);

		}

int differ (const void *self, const void *b)
{	const struct Class * const *cp = self;
	assert(self && *cp && (*cp)->differ);

	return (*cp)->differ(self,b);
}

size_t sizeOf(const void *self)
{	const struct Class * const *cp = self;

	assert(self && *cp);
	return (*cp)->size;
}

void *clone (const void *self)
{	const struct Class * const *cp=self;
	assert(self && *cp && (*cp)->clone);

	return (*cp)->clone(self);
}
