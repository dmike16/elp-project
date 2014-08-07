/*
 * main.cpp
 *
 *  Created on: 07/ago/2014
 *      Author: dmike
 */

#include <iostream>
#include <fstream>
#include <string>

using namespace std;

int main()
{	string word;
	ifstream in("es3/Debug/makefile");
	unsigned int count=0;

	while(in >> word)++count;

	cout<< "Number of words is :"<< count <<endl;

	return 0;

}

