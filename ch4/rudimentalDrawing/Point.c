/*
 * Point.c
 *
 *  Created on: 06/ago/2014
 *      Author: dmike
 */

#include <stdio.h>
#include <stdarg.h>

#include "new_r.h"
#include "Point.h"
#include "Point_a.h"

struct Point{
	const void *class;
	int x,y;
};

static void *Point_ctor (void *_self, va_list *app)
{	struct Point *self = _self;

	typedef int integer;
	self->x = va_arg(*app,integer);
	self->y = va_arg(*app,integer);

	return self;
}

static void Point_draw (const void *_self)
{	const struct Point *self = _self;

	printf("\".\" at %d,%d\n",self->x,self->y);
}

static const struct Class _Point = {
		sizeof(struct Point), Point_ctor, 0, Point_draw
};

const void *Point = &_Point;

void move (void *_self,int dx, int dy)
{	struct Point *self = _self;

	self->x += dx, self->y += dy;
}

int x(const void *_self)
{	const struct Point *self = _self;

	return self->x;
}

int y(const void *_self)
{	const struct Point *self = _self;

	return self->y;
}
