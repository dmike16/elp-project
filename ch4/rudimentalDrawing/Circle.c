/*
 * Circle.c
 *
 *  Created on: 06/ago/2014
 *      Author: dmike
 */

#include <stdio.h>
#include <assert.h>
#include <stdarg.h>

#include "new_r.h"
#include "Circle_r.h"
#include "Circle.h"

static void *Circle_ctor (void *_self,va_list *app)
{	struct Circle *self =
		((const struct Class*)Point)->ctor(_self,app);

typedef int integer;
self->rad = va_arg(*app,integer);

return self;
}


static void Circle_draw (const void *_self)
{	const struct Circle *self = _self;

	printf("circle at %d,%d rad %d\n",
			x(self),y(self),self->rad);

}

static const struct Class _Circle = {
		sizeof(struct Circle), Circle_ctor,0,Circle_draw
};

const void *Circle = &_Circle;
