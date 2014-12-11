#ifndef OBJ_H
#define OBJ_H

#include <iostream>

class Obj
{
public:
    Obj(){};
    void f(){std::cout<<i++<<std::endl;}
    void g(){std::cout<<j++<<std::endl;}
private:
    static int i,j;
};

#endif // OBJ_H
