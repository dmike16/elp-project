/*
 * stack.hpp
 *
 *  Created on: 31/ago/2014
 *      Author: dmike
 */

#ifndef STACK_HPP_
#define STACK_HPP_

class Stack {
public:
	Stack();
	~Stack();
	void push(void* dat);
	void* peek();
	void* pop();
private:
	struct Cheshire;
	Cheshire* smile;
};



#endif /* STACK_HPP_ */
