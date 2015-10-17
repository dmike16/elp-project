#include <iostream>
#include "torriHanoi.hxx"

int main(){
	torriHanoi(10,"primo","secondo","terzo");
	std::cout<< "--------Polinomial Hanoi---------"<<std::endl;
	torriHanoiP(10,4);
	return 0;
}