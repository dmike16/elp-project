/*
 * Cpplib.cpp
 *
 *  Created on: 28/ago/2014
 *      Author: dmike
 */

#include "Cpplib.hpp"
#include <iostream>
#include <cassert>
using namespace std;

const int increment = 100;

void Stash::initialize(int sz){
	size = sz;
	quantity = 0;
	storage = 0;
	next = 0;
}

int Stash::add(const void* element){
	if(next >= quantity)
		inflate(increment);
	int startBytes = next*size;
	unsigned char* e = (unsigned char*)element;
	for(int i=0; i<size;i++)
		storage[startBytes + i]=e[i];
	next++;
	return(next-1);
}

void* Stash::fetch(int index){
	assert(0<=index);
	if(index>=next)
		return 0;

	return &(storage[index*size]);
}

int Stash::count(){
	return next;
}

void Stash::inflate(int increase){
	assert(increase>0);
	int newQuantity = quantity+increase;
	int newBytes = newQuantity *size;
	int oldBytes = quantity *size;
	unsigned char* b = new unsigned char[newBytes];

	for(int i=0; i<oldBytes; i++)
		b[i]=storage[i];
	delete []storage;
	storage = b;
	quantity = newQuantity;
}

void Stash::cleanup(){
	if(storage != 0){
		cout<<"freeing storage"<<endl;
		delete []storage;
	}
}
