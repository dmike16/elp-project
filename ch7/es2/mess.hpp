/*
 * mess.hpp
 *
 *  Created on: Sep 11, 2014
 *      Author: dmike
 */

#ifndef MESS_HPP_
#define MESS_HPP_

#include <string>

class Message{
public:
	Message(std::string mess="Hello");
	void print();
	void print(std::string newMess);
private:
	std::string Xmess;
};



#endif /* MESS_HPP_ */
