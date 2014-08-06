/*
 * new_r.h
 *
 *  Created on: 06/ago/2014
 *      Author: dmike
 */

#ifndef NEW_R_H_
#define NEW_R_H_

struct Class {
	size_t size;
	void * (*ctor) (void *self,va_list *app);
	void * (*dtor) (void *self);
	void (*draw) (const void *self);
};

#endif /* NEW_R_H_ */
