/*
 * ror.cpp
 *
 *  Created on: 08/ago/2014
 *      Author: dmike
 */

unsigned char ror (unsigned char val)
{	int lowbit;
	if(val & 1)
		lowbit =1;
	else
		lowbit =0;
	val >>=1;
	val |=(lowbit <<= 7);

	return val;
}



