/*
 * =====================================================================================
 *
 *       Filename:  animal.hpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  07/02/2015 00:28:32
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */
#ifndef ANIMAL_H
#define ANIMAL_H

class Animals{
    public:
        virtual int run(int i) const{
            std::cout<< "run\n";
            return i;
        }
        virtual int eat(int i)const {
            std::cout<<"eat\n";
            return i;
        }
        virtual int sleep(int i)const{
            std::cout << "ZZZ\n";
            return i;
        }
        typedef int (Animals::*PMF)(int)const;
        class FunctionObject{
            public:
                FunctionObject(Animals& wp,PMF pmf):ptr(wp),pmem(pmf){
                    std::cout <<"FunctionObject constructor\n";
                }
                int operator()(int i)const{
                    std::cout<<"FunctionObject::operator()\n";
                    return (ptr.*pmem)(i);
                }
            private:
                Animals& ptr;
                PMF pmem;
        };
        FunctionObject operator->*(PMF pmf){
            std::cout<<"operator->*"<<std::endl;
            return FunctionObject(*this,pmf);
        }
};
#endif
