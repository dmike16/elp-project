/*
 * classtash.hpp
 *
 *  Created on: 30/ago/2014
 *      Author: dmike
 */

#ifndef CLASSTASH_HPP_
#define CLASSTASH_HPP_

class Stash{
public:
	void initialize(int size);
	void cleanup();
	int add(const void *element);
	void* fetch(int index);
	int count();
private:
	class Cheshire;
	Cheshire* smile;
};



#endif /* CLASSTASH_HPP_ */
