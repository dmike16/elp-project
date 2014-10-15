/*
 * mirror2.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"

// Problematic Approc
//extern Mirror obj;
//Mirror obj2(obj);

// First Solution. Use a class to initializer static Object
//#include "solu1.hpp"

// Second solution use function to initialiate the static Object
#include "obj.hpp"
#include "obj2.hpp"

Mirror* secondObj(){
	static Mirror obj2(firstObj());
	return &obj2;
}

/*
 * Mirror& secondObj(){
	static Mirror obj2(firstObj());
	return obj2;
}
 */
