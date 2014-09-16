/*
 * main.cpp
 *
 *  Created on: Sep 16, 2014
 *      Author: dmike
 */

#include "stringStack.hpp"
#include <iostream>
using namespace std;

static string iceCream[]={
		"p&c",
		"fr",
		"jaf",
		"wmb",
		"rs",
		"ls",
		"rr",
		"dcf"
};

const int iCsz=sizeof(iceCream)/sizeof(*iceCream);

int main(){
	StringStack ss;
	const StringStack se;
	se.print();
	for(int i=0;i<iCsz;i++)
		ss.push(&iceCream[i]);
	ss.print();
	while(ss.pop() != 0);
	ss.print();
}

