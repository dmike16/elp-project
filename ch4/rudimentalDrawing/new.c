/*
 * new.c
 *
 *  Created on: 06/ago/2014
 *      Author: dmike
 */

#include <stdio.h>
#include <malloc.h>
#include <assert.h>
#include <stdarg.h>

#include "new_r.h"
#include "new.h"


void *new(const void *_class, ...)
{	const struct Class *class = _class;
	void *p = calloc(1,class->size);

	assert(p);
	*(const struct Class **)p = class;

	if(class->ctor)
	{	va_list ap;

		va_start(ap,_class);
		p = class ->ctor(p,&ap);
		va_end(ap);
	}

	return p;
}

void delete (void *_self)
{	const struct Class **cp = _self;

	if(_self && *cp && (*cp)->dtor)
		_self = (*cp)->dtor(_self);
	free(_self);
}

void draw (const void *_self)
{	const struct Class *const *cp = _self;

	assert(_self && *cp && (*cp)->draw);
	(*cp)->draw(_self);
}
