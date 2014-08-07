/*
 * main.cpp
 *
 *  Created on: 07/ago/2014
 *      Author: dmike
 */

#include <iostream>
using namespace std;

const float pi = 3.14F;

int main()
{	float radius;

	cout << "Enter the radius:";
	cin >> radius;

	cout << "The circle's area is:"
			<< radius*radius*pi<<endl;

	return 0;

}

