/*
 * main.cpp
 *
 *  Created on: Sep 11, 2014
 *      Author: dmike
 */

#include "text.hpp"
#include <iostream>
using namespace std;

int main(int arg, char* argv[]){
	if(arg !=2){
		cout << "Wrong usage. Give me a only one fileNAam"<<endl;
		return 1;
	}

	Text file(argv[1]);

	cout << "File Contentets:\n"
			<< file.contents()<<endl;

	return 0;
}



