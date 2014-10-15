/*
 * estaticlass.hpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#ifndef ESTATICLASS_HPP_
#define ESTATICLASS_HPP_
#include "esclass.hpp"

namespace sta{
	class eStatiClass{
	public:
		static void f(){
			statico.print();
		}
	private:
		static example::esClass statico;
	};
}




#endif /* ESTATICLASS_HPP_ */
