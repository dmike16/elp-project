/*
 * stack.cpp
 *
 *  Created on: 31/ago/2014
 *      Author: dmike
 */

#include "stack.hpp"
#include <iostream>
#include <cassert>
using namespace std;

struct Stack::Cheshire {
	struct Link{
		void* data;
		Link* next;
		Link(void* dat,Link* nxt);
		~Link();
	}*head;
};

Stack::Cheshire::Link::Link(void* dat, Link* nxt){
	data=dat;
	next=nxt;
}

Stack::Cheshire::Link::~Link(){}

Stack::Stack(){
	smile = new Cheshire;
	smile->head=0;
}

void Stack::push(void* dat){
	smile->head = new Stack::Cheshire::Link(dat,smile->head);
}

void* Stack::peek(){
	assert(smile->head !=0);

	return smile->head->data;
}

void* Stack::pop(){
	if(smile->head==0)return 0;

	void* result = smile->head->data;
	Stack::Cheshire::Link* oldHead = smile->head;
	smile->head =smile->head->next;
	delete oldHead;
	return result;
}

Stack::~Stack(){
	assert(smile->head == 0);
	delete smile;
}
