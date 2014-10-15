/*
 * main.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "fibonacci.hpp"
#include <iostream>
using namespace std;

int main(){
	cout << "--------------------------"<<endl;
	cout << "   Fibonacci Sequenze     "<<endl;
	cout << "--------------------------"<<endl;

	int index;
	cout<< " Index of Fibinacci: ",cin>> index;
	for(int i=0; i< index; i++)
		cout<< fibonacciNext()<<",";
	cout<<"..."<<endl;
	cout<<" Reset To the beginning"<<endl;
	fibonacciNext(true);

	for(int i=0; i< 10; i++)
			cout<< fibonacciNext()<<",";
		cout<<"..."<<endl;

	return 0;
}
