/*
 * cpptime.cpp
 *
 *  Created on: Oct 7, 2014
 *      Author: dmike
 */

#include "cpptime.hpp"
using namespace std;


const char* Time::ascii(){
	updateAscii();
	return asciiRep;
}

int Time::delta(Time* dt)const{
	return int(difftime(t,dt->t));
}
