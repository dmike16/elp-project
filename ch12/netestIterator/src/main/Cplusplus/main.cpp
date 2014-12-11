#include "objcontainer.h"

int main(){
    const int sz = 10;
    Obj o[sz];
    ObjContainer oc;

    for(int i=0; i<sz; i++)
        oc.add(&o[i]);
    ObjContainer::SmartPointer sp = oc.begin();
    do{
        sp->f();
        sp->g();
    }while(++sp);
}
