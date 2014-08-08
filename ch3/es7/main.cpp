/*
 * main.cpp
 *
 *  Created on: 08/ago/2014
 *      Author: dmike
 */

#include <iostream>
#include <string>

using namespace std;

void modOne(string *s);
void modTwo(string& s);

int main ()
{	string s="Hello Android";

	cout << s <<endl;
	modOne(&s);
	cout<< s <<endl;
	modTwo(s);
	cout << s << endl;

	return 0;

}

void modOne(string *s)
{
	*s = *s+".Bella";
}

void modTwo(string& s)
{
	s = s + ".Super Jolla";
}
