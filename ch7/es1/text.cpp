/*
 * text.cpp
 *
 *  Created on: Sep 11, 2014
 *      Author: dmike
 */

#include "text.hpp"
#include <fstream>
#include <iostream>
#include <string>
#include <cassert>
using namespace std;

class Text::Cheshire{
public:
	Cheshire();
	Cheshire(char* self);
	friend string Text::contents();
private:
	string inFile;
};

Text::Text(){ smile = new Cheshire;}
Text::Cheshire::Cheshire(){inFile = "";}

Text::Text(char* self){
	smile = new Cheshire(self);
}
Text::Cheshire::Cheshire(char* self){
	Cheshire();
	ifstream in(self);
		assert(in);
		string tmp="";
		while(getline(in,tmp)){
			inFile += tmp;
			inFile += "\n";
		};

		in.close();
}

Text::~Text(){ delete smile;}

string Text::contents(){ return smile->inFile;}
