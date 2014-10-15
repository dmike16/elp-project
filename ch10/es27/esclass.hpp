/*
 * esclass.hpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#ifndef ESCLASS_HPP_
#define ESCLASS_HPP_
#include <iostream>

namespace example{
class esClass {
public:
	esClass (int nn): n(nn){};
	void print(){
		std::cout<< "Member int : "<< n <<std::endl;
	}
private:
	int n;
};
}

#endif /* ESCLASS_HPP_ */
