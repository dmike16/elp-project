/*
 * libc.hpp
 *
 *  Created on: 31/ago/2014
 *      Author: dmike
 */

#ifndef LIBC_HPP_
#define LIBC_HPP_

#include <string>

class Libc {
public:
	void seta(std::string sa);
	std::string geta();
	void setb(std::string sb);
	std::string getb();
	void setc(std::string sc);
	std::string getc();
private:
	std::string s[3];
};


#endif /* LIBC_HPP_ */
