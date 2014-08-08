/*
 * rol.cpp
 *
 *  Created on: 08/ago/2014
 *      Author: dmike
 */

unsigned char rol (unsigned char val)
{	int hightbit;
	if(val & 0x80)
		hightbit =1;
	else
		hightbit =0;
	val <<=1;
	val |=hightbit;

	return val;
}


