/*
 * =====================================================================================
 *
 *       Filename:  main.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  06/02/2015 18:32:35
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#include <iostream>
#include "Shape.hpp"
#include "Circle.hpp"
#include "Square.hpp"

using namespace std;
using namespace shape;

int main (){
   Circle c;
   Shape* s=&c;
   Circle *cp = 0;
   Square *sq = 0;
   if(s->WhatIAm() == Circles)
    cp = static_cast<Circle*>(s);
  if(s->WhatIAm()== Squares)
    sq = static_cast<Square*>(s);
  if(cp != 0)
    cout<< "It's a circle"<<endl;
  if(sq !=0)
    cout<<"It's a Square"<<endl;

  return 0;
}