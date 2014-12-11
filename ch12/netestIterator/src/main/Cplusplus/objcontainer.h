#ifndef OBJCONTAINER_H
#define OBJCONTAINER_H

#include <iostream>
#include <vector>
#include "obj.h"

class ObjContainer{
public:
    void add(Obj* obj){a.push_back(obj);}
    class SmartPointer;
    friend SmartPointer;
    class SmartPointer{
    public:
        SmartPointer(ObjContainer& obj): oc(obj){
            index=0;
        }
        bool operator ++(){
            if(index >= oc.a.size()) return false;
            if(oc.a[++index] == 0) return false;
            return true;
        }
        bool operator ++(int){
            return operator++();
        }
        Obj* operator ->() const {
            // Insert Controll over vector a
            return oc.a[index];
        }
    private:
        ObjContainer& oc;
        unsigned int index;
    };
    SmartPointer begin(){
        return SmartPointer(*this);
    }
private:
    std::vector<Obj*> a;
};

#endif // OBJCONTAINER_H
