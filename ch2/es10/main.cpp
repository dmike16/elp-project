/*
 * main.cpp
 *
 *  Created on: 07/ago/2014
 *      Author: dmike
 */

#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{	vector<float> v;

	cout << "Before operation"<<endl;

	for(int i=0; i<25; i++)
	{	v.push_back(25*i);
		cout << v[i]<<" ";
	}

	cout <<endl<<"After operation"<<endl;

	int s_ize = v.size();
	for(int i = 0; i<s_ize; i++)
	{	v[i]=sqrt(v[i]);
		cout << v[i]<<" ";
	}
	cout<<endl;
return 0;

}



