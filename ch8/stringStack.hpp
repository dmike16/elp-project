/*
 * stringStack.hpp
 *
 *  Created on: Sep 16, 2014
 *      Author: dmike
 */

#ifndef STRINGSTACK_HPP_
#define STRINGSTACK_HPP_

#include <string>

class StringStack {
public:
	StringStack();
	void push(const std::string* s);
	const std::string* pop();
	void print() const;
private:
	static const int size = 100;
	const std::string* stack[size];
	int index;
};


#endif /* STRINGSTACK_HPP_ */
