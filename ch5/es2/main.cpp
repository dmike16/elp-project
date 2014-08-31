/*
 * main.cpp
 *
 *  Created on: 31/ago/2014
 *      Author: dmike
 */

#include "libc.hpp"
#include <iostream>
using namespace std;

int main(){
	Libc ss;

	ss.seta("Bella");
	ss.setb("de");
	ss.setc("zio");

	cout<< ss.geta()<<" "<< ss.getb()
			<< " "<<ss.getc()<<endl;

	return 0;
}


