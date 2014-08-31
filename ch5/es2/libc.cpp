/*
 * libc.cpp
 *
 *  Created on: 31/ago/2014
 *      Author: dmike
 */

#include "libc.hpp"
using namespace std;

void Libc::seta(string sa){
	s[0] = sa;
}

void Libc::setb(string sb){
	s[1] = sb;
}

void Libc::setc(string sc){
	s[2] = sc;
}

string Libc::geta(){
	return s[0];
}

string Libc::getb(){
	return s[1];
}

string Libc::getc(){
	return s[2];
}


