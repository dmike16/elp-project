/*
 * main.cpp
 *
 *  Created on: 01/set/2014
 *      Author: dmike
 */

#include "stack.hpp"
#include <fstream>
#include <iostream>
#include <cassert>
#include <string>
using namespace std;

int main (int argc, char* argv[]){
	assert(argc >= 1);
	ifstream in(argv[1]);
	assert(in);

	Stack texlines;
	string line;

	while(getline(in,line))
		texlines.push(new string(line));

	string *s;
	while((s=static_cast<string*>(texlines.pop())) != 0){
		cout<< *s <<endl;
		delete s;
	}
	return 0;
}
