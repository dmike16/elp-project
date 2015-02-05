/*
 * =====================================================================================
 *
 *       Filename:  OStack.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/02/2015 18:08:51
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#ifndef OSTACK_H
#define OSTACK_H

class Object {
    public: 
        virtual ~Object()=0;
};

class Stack{
    public:
        Stack(): head(0){}
        ~Stack(){
            while(head)
                delete pop();
        }
        void push(Object *dat);
        Object* peek() const;
        Object* pop();

    private:
        struct Link{
            Object *data;
            Link* next;
            Link(Object* dat,Link* nxt): data(dat),next(nxt){}
        }* head;
};
#endif
