/*
 * =====================================================================================
 *
 *       Filename:  Circle.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  06/02/2015 18:59:36
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */
#ifndef CIRCLE_H
#define CIRCLE_H

#include "Shape.hpp"

namespace shape {
    class Circle: public Shape {
        public:
            Type WhatIAm() const {
                return Circles;
            }
    };
}
#endif
