/*
 * =====================================================================================
 *
 *       Filename:  OStack.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/02/2015 18:27:07
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#include "OStack.hpp"

Object::~Object(){}

void Stack::push(Object* dat){
    head = new Link(dat,head);
}
Object* Stack::peek()const{
    return head ? head->data:0;
}
Object* Stack::pop(){
    if(head==0)return 0;
    Object* result = head->data;
    Link* oldHead = head;
    head=head->next;
    delete oldHead;
    return result;
}
