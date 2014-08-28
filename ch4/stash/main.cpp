/*
 * main.cpp
 *
 *  Created on: 28/ago/2014
 *      Author: dmike
 */

#include "Cpplib.hpp"
#include <iostream>
#include <cassert>
using namespace std;

int main(){
	Stash intStash;
	intStash.initialize(sizeof(int));

	for(int i=0; i<100; i++)
		intStash.add(&i);
	for(int j=0; j<intStash.count();j++)
		cout << "intStash.fetch("<<j<<")="
				<< *static_cast<int*>(intStash.fetch(j))
				<<endl;

	return 0;
}



