/*
 * main.cpp
 *
 *  Created on: 08/ago/2014
 *      Author: dmike
 */

#include <iostream>
using namespace std;

void printVecDouble(double *self,int dim)
{
	for(int i =0; i <dim; i++)
		cout<<self[i]<<" ";
	cout<<endl;
}

int main ()
{	double d[5]={0,0,0,0,0};

	printVecDouble(d,5);

	unsigned char *dc = reinterpret_cast<unsigned char*>(d);

	for(int i =0; i <5*static_cast<int>(sizeof(double)); i++)
		dc[i]=0x1;

	printVecDouble(d,5);

	return 0;
}


