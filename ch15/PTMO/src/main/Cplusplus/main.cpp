#include <iostream>
#include "dog.hpp"
using namespace std;

int main()
{
    Dog d;
    Animals* a = &d;
    Animals::PMF pmf = &Animals::run;
    cout<<(a->*pmf)(1)<<endl;
    pmf = &Animals::eat;
    cout<<(a->*pmf)(2)<<endl;
    pmf = &Animals::sleep;
    cout<<(a->*pmf)(3)<<endl;
}

