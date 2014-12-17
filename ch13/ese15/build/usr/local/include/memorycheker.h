#ifndef MEMORYCHEKER_H
#define MEMORYCHEKER_H
#include"widget.h"

class MemoryCheker
{
public:
    ~MemoryCheker(){
       trace << "Number of Widget Not relese: "<< Widget::getWidgetNumbers() <<"\n";
    }

private:
    static MemoryCheker memCheck;
    MemoryCheker(){}
    MemoryCheker(const MemoryCheker&);
};

#endif // MEMORYCHEKER_H
