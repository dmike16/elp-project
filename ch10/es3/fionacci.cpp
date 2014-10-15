/*
 * fionacci.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "fibonacci.hpp"

long int fibonacciNext(bool reset /* = false */){
	static long int anext;
	static long int aprew;

	if(reset){
		anext = aprew =0;
		return anext;
	}
	else if(!anext){
		anext = 1;
		return anext;
	}
	else if (!aprew){
		aprew = anext;
		return anext;
	}
	long int atmp = anext;
	anext += aprew;
	aprew =atmp;
	return anext;

}



