/*
 * Cpplib.hpp
 *
 *  Created on: 28/ago/2014
 *      Author: dmike
 */

#ifndef CPPLIB_HPP_
#define CPPLIB_HPP_

struct Stash {
	int size;
	int quantity;
	int next;
	unsigned char *storage;
	void initialize(int size);
	void cleanup();
	int add(const void* element);
	void* fetch(int index);
	int count ();
	void inflate(int increase);
};



#endif /* CPPLIB_HPP_ */
