/*
 * =====================================================================================
 *
 *       Filename:  travel.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  19/01/2015 18:39:56
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#ifndef TRAVEL_H
#define TRAVEL_H

#include <iostream>
#include <string>

class Travel {
    public:
        Travel(const std::string nm): name(nm){
            std::cout << "Travel string constructor"<<std::endl;
        }
        Travel(const Travel& obj): name(obj.name){
            std::cout <<"Travel copy-constructor"<<std::endl;
        }
        Travel& operator=(const Travel& rg){
            std::cout<< "Travel = operator"<<std::endl;
            return *this;
        }
    private:
        std::string name;

};

class Pager{
    public:
        Pager(const std::string nm): name(nm){
            std::cout<< "Pager string constructor"<<std::endl;
        }
        Pager(const Pager& obj):name(obj.name){
            std::cout<< "Pager copy-constructor"<<std::endl;
        }
        Pager& operator=(const Pager& rg){
            std::cout <<"Pager = operator"<<std::endl;
            return *this;
        }
    private:
        std::string name;
};

#endif