/*
 * myClass.cpp
 *
 *  Created on: 01/set/2014
 *      Author: dmike
 */

#include "myClass.hpp"
#include <iostream>
using namespace std;

myClass::myClass(){
	iM = 16;
	cout<<"Call of constructor"
			<<"default number "<<iM<<endl;
}

myClass::~myClass(){
	cout<< "Call destructor, Object out of scope"
			<<endl;
}


