/*
 * main.cpp
 *
 *  Created on: 08/ago/2014
 *      Author: dmike
 */

#include "printBinary.hpp"
#include "rightRol.hpp"
#include "leftRol.hpp"
#include <iostream>
#include <fstream>
using namespace std;

#define PR(STR,EXPR)\
	cout<<STR;printBinary(EXPR);cout<<endl;

static unsigned char (*vec[2])(unsigned char)={
		rol,ror
};
static int index = 0;

int main ()
{	unsigned int getval;
	unsigned char a;
	cout<< "Enter a number in [0,255]";
	cin >> getval;
	a = static_cast<char> (getval);
	PR("a in binary; ",a);
	char tmp;
	char choise;
	cout<< "MENU\n"
			<< "r) right rotate\n"
			<< "l) left rotate\n"
			<< "q) quit" <<endl;
	cin >> choise;
	switch(choise){
	case 'l':
		cout << "Left rotate a"<<endl;
		break;
	case 'r':
		cout << "Right rotate a"<<endl;
		index = 1;
		break;
	default:
		return 0;
	}

	for(;;)
	{	tmp=getchar();
		while(tmp!='\n' && tmp!='q');
		if(tmp == 'q')
			break;
		else
			PR("<-o-> ",(a=vec[index](a)));
	}
	return 0;
}



