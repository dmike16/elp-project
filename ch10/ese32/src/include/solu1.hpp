/*
 * solu1.hpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#ifndef SOLU1_HPP_
#define SOLU1_HPP_

#include <iostream>

extern Mirror* obj;
extern Mirror* obj2;
extern Mirror* obj3;
extern Mirror* obj4;
extern Mirror* obj5;

class Initializer {
public:
	Initializer(){
		std::cout << "Initializer()"<<std::endl;
		if(defCount++ == 0){
			std::cout << "Performing initialization"<<std::endl;
			obj = new Mirror;
			obj2 = new Mirror(obj);
			obj3 = new Mirror(obj2);
			obj4 = new Mirror(obj3);
			obj5 = new Mirror(obj4);
		}
	}
	~Initializer(){
		std::cout <<"~Initializer()"<<std::endl;
		if(--defCount == 0){
			std::cout<<"Performing cleanup"<<std::endl;
			delete obj5,delete obj4, delete obj3, delete obj2, delete obj;
		}
	}
private:
	static int defCount;
};

static Initializer init;

#endif /* SOLU1_HPP_ */
