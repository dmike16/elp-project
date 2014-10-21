/*
 * mirror3.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"

// Problematic Approc
//extern Mirror obj2;
//Mirror obj3(obj2);

// First Solution. Use a class to initializer static Object
//#include "solu1.hpp"

// Second solution use function to initialiate the static Object
#include "obj2.hpp"
#include "obj3.hpp"


Mirror& thirdObj(){
	static Mirror obj3(secondObj());
	return obj3;
}
/*Mirror* thirdObj(){
	static Mirror obj3(secondObj());
	return &obj3;
}
*/
/*
 * Mirror& thirdObj(){
	static Mirror obj3(secondObj());
	return obj3;
}
 *
 */
