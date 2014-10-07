/*
 * cpptime.hpp
 *
 *  Created on: Oct 7, 2014
 *      Author: dmike
 */

#ifndef CPPTIME_HPP_
#define CPPTIME_HPP_

#include <ctime>
#include <cstring>

class Time {
public:
	Time(){mark();}
	void mark(){
		lflag= aflag =0;
		std::time(&t);
	}
	const char* ascii();
	int delta(Time *dt)const;
private:
	std::time_t t;
	std::tm local;
	char asciiRep[26];
	unsigned char lflag,aflag;
	void updateLocal(){
		if(!lflag){
				local =*localtime(&t);
				lflag++;
			}
	}
	void updateAscii(){
		if(!aflag){
				updateLocal();
				strcpy(asciiRep,asctime(&local));
				aflag++;
			}
	}
};



#endif /* CPPTIME_HPP_ */
