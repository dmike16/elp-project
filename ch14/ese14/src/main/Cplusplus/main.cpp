/*
 * =====================================================================================
 *
 *       Filename:  main.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  19/01/2015 19:27:46
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#include "bussinessTravel.hpp" 
using namespace std;

void bella(BusinessTravel ehi){
    cout<< "Inside function copy call for the argument"<<endl;
}

int main(){
    BusinessTravel hi;
    BusinessTravel ohi("First Travel");

    hi = ohi;
    bella(hi);
    return 0;
}


