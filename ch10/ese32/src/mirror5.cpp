/*
 * mirror5.cpp
 *
 *  Created on: Oct 15, 2014
 *      Author: dmike
 */

#include "mirror.hpp"
#include <iostream>
using namespace std;

// Problematic Approc
//extern Mirror obj4;
//Mirror obj5(obj4);

// First Solution. Use a class to initializer static Object
//#include "solu1.hpp"

// Second solution use function to initialiate the static Object
#include "obj4.hpp"
#include "obj5.hpp"

Mirror& fifthObj(){
	static Mirror obj5(forthObj());
	return obj5;
}
/*Mirror* fifthObj(){
	static Mirror obj5(forthObj());
	return &obj5;
}
*/
/*
 * Mirror& fifthObj(){
	static Mirror obj5(forthObj());
	return obj5;
}
 */

int main(){
	cout<< "in main"<<endl;
	//cout<< "The result is: "<<obj5->test()<<endl;
	cout<< "The result is: "<<fifthObj().test()<<endl;
	//cout<< "The status is:" <<fifthObj().get_status()<<endl;
	//cout<< "The result is: "<<fifthObj()->test()<<endl;
	cout<<"leaving main"<<endl;
	return 0;
}
