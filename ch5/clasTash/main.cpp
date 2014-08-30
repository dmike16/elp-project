/*
 * main.cpp
 *
 *  Created on: 30/ago/2014
 *      Author: dmike
 */

#include "classtash.hpp"
#include <iostream>

using namespace std;

int main(){
	Stash intStash;

	intStash.initialize(sizeof(int));
	for(int i =0; i <100; i++)
		intStash.add(&i);
	for(int j =0; j <intStash.count(); j++)
		cout<<"intStash.fetch("<<j<<") ="
			<<*(int*)intStash.fetch(j)
			<<endl;
	intStash.cleanup();
	return 0;
}


