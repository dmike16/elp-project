/*
 * mirror.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"

bool Mirror::test(){
	if(!mir)
		return status;
	else
		return mir->test();
}
