/*
 * staticDecostructor.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include <fstream>
#include <cstdlib>

using namespace std;

ofstream out("statdest.out");

class Obj {
public:
	Obj(char cc): c(cc){
		out<< "Obj::Obj() for "<< c<<endl;
	}
	~Obj(){
		out<< "Obj::~Obj() for "<< c<<endl;
		//exit(0);
	}

private:
	char c;
};

Obj a('a');

void f(){
	static Obj b=Obj('b');
}

void g(){
	static Obj c('c');
}

int main(){
	out << "Inside Main"<<endl;
	f();
	g();
	out<<"Leaving main()"<<endl;

	return 0;
}
