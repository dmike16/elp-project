/*
 * StringStack.cpp
 *
 *  Created on: Sep 16, 2014
 *      Author: dmike
 */

#include "stringStack.hpp"
#include <iostream>
#include <cstring>
using namespace std;

StringStack::StringStack(): index(0) {
	memset(stack,0,size*sizeof(string*));
}

void StringStack::push(const string* s){
	if(index < size)
		stack[index++] =s;
}

const string* StringStack::pop(){
	if(index >0){
		const string* rv = stack[--index];
		stack[index] =0;
		return rv;
	}
	return 0;
}

void StringStack::print()const{
	if(index >0)
		for(int i =0; i <index; i++)
			cout <<*stack[i]<<endl;
	else
		cout<< "Stack Array Empty"<<endl;
}

