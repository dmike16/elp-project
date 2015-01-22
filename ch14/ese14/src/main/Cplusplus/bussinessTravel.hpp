/*
 * =====================================================================================
 *
 *       Filename:  bussinessTravel.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  19/01/2015 19:07:38
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */
#ifndef BUSINESSTRAVEL_H
#define BUSINESSTRAVEL_H

#include "travel.hpp"

class BusinessTravel: public Travel{
    public:
        BusinessTravel():Travel(""),one(""){
            std::cout << "BusinessTravel default constructor"<<std::endl;
        }
        BusinessTravel(const std::string nm): Travel(nm),one(nm){
            std::cout << "BusinessTravel string constructor"<<std::endl;}

        BusinessTravel(const BusinessTravel& obj): Travel(obj),one(obj.one){
            std::cout << "BusinessTravel copy-constructor"<<std::endl;}

        BusinessTravel& operator=(const BusinessTravel& rg){
            Travel::operator =(rg);
            one = rg.one;
            std::cout << "BusinessTravel = operator"<<std::endl;
            return *this;
        }
    private:
        Pager one;
};

#endif
