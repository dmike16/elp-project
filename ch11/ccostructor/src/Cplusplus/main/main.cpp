#include <iostream>
#include <fstream>
#include <string>
#include "howmany.h"

using namespace std;
ofstream out("HowMany.out");

HowMany f(HowMany x){
    x.print("x argument inside f()");
    return x;
}

int main()
{
    HowMany h;
    HowMany::print("after construction of h");
    f(h);
    HowMany::print("after call to f()");
    return 0;
}

