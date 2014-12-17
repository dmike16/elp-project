#ifndef FRAMIS_H
#define FRAMIS_H

#include <cstddef>
#include <fstream>
#include <new>
extern std::ofstream out;

class Framis
{
public:
    static const int psize=100;
    Framis(){ out << "Framis()\n";}
    ~Framis(){out << "~Framis().....";}
    void *operator new(std::size_t) throw(std::bad_alloc);
    void operator delete(void*);
private:
    static const int sz =10;
    char c[sz];
    static unsigned char pool[];
    static bool alloc_map[];
};

#endif // FRAMIS_H
