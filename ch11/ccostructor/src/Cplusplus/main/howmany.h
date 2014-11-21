#ifndef HOWMANY_H
#define HOWMANY_H
#include <string>
#include <iostream>
#include <fstream>

extern std::ofstream out;

class HowMany
{
    static int objectCount;
public:
    HowMany(){ objectCount++;};
    static void print(const std::string& msg =""){
        if(msg.size() != 0) out<<msg<<":";
        out<<"objectCount ="<<objectCount<<std::endl;
    }
    ~HowMany(){
        objectCount--;
        print("~HowMany");
    }
    HowMany(const HowMany& x){
        ++objectCount;
        print("HowMany Copy Constructor");
    }
};

#endif // HOWMANY_H
