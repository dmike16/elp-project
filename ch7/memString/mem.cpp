/*
 * mem.cpp
 *
 *  Created on: 05/set/2014
 *      Author: dmike
 */

#include "mem.hpp"
#include <cstring>
using namespace std;

class Mem::Cheshire{
public:
	Cheshire();
	~Cheshire();
	friend Mem::Mem(int sz);
	friend int Mem::msize();
	friend byte* Mem::pointer(int minSize=0);
private:
	byte* mem;
	int size;
	void ensureMinSize(int sz);
};

Mem::Cheshire::Cheshire(){
	mem = 0;
	size = 0;
}

Mem::Cheshire::~Cheshire(){
	delete []mem;
}

Mem::Mem() {
	smile = new Cheshire();
}

Mem ::Mem(int sz){
	smile = new Cheshire();
	smile->ensureMinSize(sz);
}

Mem::~Mem(){
	delete smile;
}

int Mem::msize(){ return smile->size; }

void Mem::Cheshire::ensureMinSize(int minSize){
	if (size < minSize) {
		byte* newmem = new byte[minSize];
		memset(newmem + size, 0, minSize -size);
		memcpy(newmem, mem, size);
		delete []mem;
		mem = newmem;
		size = minSize;
	}
}

byte* Mem::pointer(int minSize){
	smile->ensureMinSize(minSize);
	return smile->mem;
}
