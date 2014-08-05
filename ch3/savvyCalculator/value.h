/*
 * value.h
 *
 *  Created on: 05/ago/2014
 *      Author: dmike
 */

#ifndef VALUE_H_
#define VALUE_H_

const void *Add;
const void *Sub;
const void *Value;
const void *Minus;

void *new (const void *type,...);
void process (const void *tree);
void delete (void *tree);

#endif /* VALUE_H_ */
