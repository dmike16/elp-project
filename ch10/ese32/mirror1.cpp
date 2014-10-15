/*
 * mirror1.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"

// Problematic Approc
// Mirror obj;

// First Solution. Use a class to initializer static Object
//#include "solu1.hpp"

// Second solution use function to initialiate the static Object
#include "obj.hpp"
Mirror* firstObj(){
	static Mirror obj;
	return &obj;
}
/*Mirror& firstObj(){
	static Mirror obj;
	return obj;
}*/
