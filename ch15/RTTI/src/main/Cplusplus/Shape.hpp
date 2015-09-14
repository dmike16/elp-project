/*
 * =====================================================================================
 *
 *       Filename:  Shape.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  06/02/2015 18:34:36
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#ifndef SHAPE_H
#define SHAPE_H

namespace shape{
    enum Type {Circles,Squares};

    class Shape{
        public:
            virtual Type WhatIAm() const = 0;
            virtual ~Shape(){};
    };
   }
#endif
