/*
 * =====================================================================================
 *
 *       Filename:  Square.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  06/02/2015 19:15:48
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */
#ifndef SQUARE_H
#define SQUARE_H

#include "Shape.hpp"

namespace shape{
    class Square: public Shape{
        public:
            Type WhatIAm() const {
                return Squares;
            }
    };
}
#endif
