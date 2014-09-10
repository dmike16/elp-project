/*
 * mess.cpp
 *
 *  Created on: Sep 11, 2014
 *      Author: dmike
 */

#include "mess.hpp"
#include <iostream>
using namespace std;

Message::Message(string mess){
	Xmess = mess;
}

void Message::print(){
	cout << Xmess <<endl;
	return;
}

void Message::print(string newMess){
	cout << Xmess + newMess <<endl;
	return;
}

int main(){
	Message mess;
	Message mess2(" Zio");

	mess.print();
	mess.print(" Frocio");

	return 0;
}

