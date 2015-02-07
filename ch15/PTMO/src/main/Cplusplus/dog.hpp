#ifndef WIDGET_H
#define WIDGET_H
#include <iostream>
#include <string>
#include "animal.hpp"

class Dog :public Animals {
    public:
        int run(int i)const {
            std::cout<< nclass << " run\n";
            return i;
        }
        int eat(int i)const{
            std::cout<< nclass <<" eat\n";
            return i;
        }
        int sleep(int i)const {
            std::cout<< nclass <<" ZZZ\n";
            return i;
        }
    private:
        static const std::string nclass;

};

#endif // WIDGET_H
