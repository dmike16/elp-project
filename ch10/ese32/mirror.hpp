/*
 * mirror.hpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#ifndef MIRROR_HPP_
#define MIRROR_HPP_
#include <iostream>

class Mirror {
public:
	Mirror(): status(true){
		std::cout<< "In default init"<<std::endl;
		mir = 0;
	}
	Mirror(Mirror *obj): status(false){
		std::cout <<" in second init\n";
		mir =obj;
	}
	~Mirror(){
		std::cout<< "Performing clean up: "<< status<<std::endl;
	}
	bool get_status (){
		return status;
	}
	bool test();
private:
	Mirror *mir;
	bool status;
};



#endif /* MIRROR_HPP_ */
