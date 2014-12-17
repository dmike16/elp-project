#include "framis.h"
using namespace std;

unsigned char Framis::pool[psize*sizeof(Framis)];
bool Framis::alloc_map[psize]={false};

void* Framis::operator new(size_t) throw(bad_alloc){
    for(int i =0; i <psize; i++)
        if(!alloc_map[i]){
            out<< "using block "<<i<<" .... ";
            alloc_map[i] =true;
            return pool + (i*sizeof(Framis));
        }
    out<<" Out of Memory "<<endl;
    throw bad_alloc();
}

void Framis::operator delete(void* m){
    if(!m) return;
    unsigned long block = (unsigned long) m - (unsigned long)pool;
    block /= sizeof(Framis);
    out << "freeing block "<<block <<endl;
    alloc_map[block] = false;
}
