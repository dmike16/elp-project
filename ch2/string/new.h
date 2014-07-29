/*
 * new.h
 *
 *  Created on: 27/lug/2014
 *      Author: dmike
 */

#ifndef NEW_H_
#define NEW_H_

void *new (const void *self,...);
void delete (void *self);
void *clone (const void *self);
int differ (const void *self,const void *b);
size_t sizeOf(const void *self);

#endif /* NEW_H_ */
