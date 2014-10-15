/*
 * mirror4.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"

// Problematic Approc
//extern Mirror obj3;
//Mirror obj2(obj3);

// First Solution. Use a class to initializer static Object
//#include "solu1.hpp"

// Second solution use function to initialiate the static Object
#include "obj3.hpp"
#include "obj4.hpp"

Mirror* forthObj(){
	static Mirror obj4(thirdObj());
	return &obj4;
}

/*
 * Mirror& forthObj(){
	static Mirror obj4(thirdObj());
	return obj4;
}
 */

