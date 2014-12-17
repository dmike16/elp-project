#include<fstream>
#include <iostream>
#include "framis.h"
using namespace std;

ofstream out("Framis.out");

int main(){
    Framis* f[Framis::psize];
    try{
        for(int i =0; i <Framis::psize; i++)
            f[i] =new Framis;
        new Framis;
    } catch(bad_alloc){
        cerr << "Out of memory"<<endl;
    }
    delete f[10];
    f[10] =0;
    Framis* x =new Framis;
    delete x;
    for(int i =0; i <Framis::psize; i++)
        delete f[i];

    return 1;
}
