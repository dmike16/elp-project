/*
 * mem.hpp
 *
 *  Created on: 05/set/2014
 *      Author: dmike
 */

#ifndef MEM_HPP_
#define MEM_HPP_

typedef unsigned char byte;

class Mem {
public:
	Mem();
	Mem(int sz);
	~Mem();
	int msize();
	byte* pointer(int minSize =0);
private:
	class Cheshire;
	Cheshire* smile;
};



#endif /* MEM_HPP_ */
