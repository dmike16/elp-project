/*
 * text.hpp
 *
 *  Created on: Sep 11, 2014
 *      Author: dmike
 */

#ifndef TEXT_HPP_
#define TEXT_HPP_

#include <string>

class Text {
public:
	Text();
	Text(char* self);
	~Text();
	std::string contents();
private:
	class Cheshire;
	Cheshire* smile;
};



#endif /* TEXT_HPP_ */
