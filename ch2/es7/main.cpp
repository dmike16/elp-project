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

int main ()
{	string line;
	ifstream in("es3/Debug/makefile");


	cout<< "Press enter to display next line"<<endl;

	while(getline(in,line))
	{	while((getchar()!='\n'));
		cout << line;
	}

	return 0;
}

