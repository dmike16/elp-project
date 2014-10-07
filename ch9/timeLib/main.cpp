/*
 * main.cpp
 *
 *  Created on: Oct 7, 2014
 *      Author: dmike
 */

#include "cpptime.hpp"
#include <iostream>
using namespace std;

int main(){
	Time start;
	for (int i=0; i< 1000000;i++){
		cout <<i<<' ';
		if(i%10==0)cout<<endl;
	}

	Time end;
	cout <<endl;
	cout <<"start= "<< start.ascii();
	cout <<"end= "<< end.ascii();
	cout <<"delta= "<<end.delta(&start)<<endl;

	return 0;
}


