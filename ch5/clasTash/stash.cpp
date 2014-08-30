/*
 * stash.cpp
 *
 *  Created on: 30/ago/2014
 *      Author: dmike
 */

#include "classtash.hpp"
#include <iostream>
#include <cassert>
using namespace std;

class Stash::Cheshire {
public:
	int size;
	int quantity;
	int next;
	unsigned char* storage;
private:
	void inflate(int increase);
	friend int Stash::add(const void* element);
};

const int increment=100;

void Stash::initialize(int sz){
	smile = new Cheshire;
	smile->size = sz;
	smile->quantity = 0;
	smile->next = 0;
	smile->storage = 0;
}

int Stash::add(const void* element){
	if(smile->next >= smile->quantity)
		smile->inflate(increment);

	int startByte = smile->next*smile->size;
	unsigned char* e = (unsigned char*)element;

	for(int i =0; i <smile->size; i++)
		smile->storage[startByte+i] =e[i];
	smile->next++;
	return(smile->next-1);
}

void* Stash::fetch(int index){
	assert(0 <=index);
	if(index >=smile->next)
		return 0;
	return &(smile->storage[index*smile->size]);
}

int Stash::count(){
	return smile->next;
}

void Stash::Cheshire::inflate(int increase){
	assert(increase >0);

	int newQuantity = quantity+increase;
	int newBytes = newQuantity*size;
	int oldBytes = quantity*size;
	unsigned char *b=new unsigned char[newBytes];

	for(int i =0; i <oldBytes; i++)
		b[i] =storage[i];
	delete []storage;
	storage = b;
	quantity =newQuantity;

}

void Stash::cleanup(){
	if(smile->storage !=0){
		cout<<"freeing storage"<<endl;
		delete []smile->storage;
		delete smile;
	}

	else
		delete smile;
}
