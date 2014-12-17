#include<fstream>
#include <iostream>
#include "widget.h"
#include "memorycheker.h"
using namespace std;

ofstream trace("Framis.out");

int main(){
    trace<<"Widget Creation"<<endl;
    Widget* wid[4];
    trace<<"\nnew Widget"<<endl;
    wid[0]=new Widget();
    trace<<"\nnew Widget"<<endl;
    wid[1]=new Widget();
    trace<<"\nnew Widget"<<endl;
    wid[2]=new Widget();
    trace<<"\nnew Widget"<<endl;
    wid[3]=new Widget();
    trace<<"\nnew Vector Widget"<<endl;
    Widget* vwid =new Widget[25];
    Widget* widd[4];
    trace<<"\nnew Widget"<<endl;
    widd[0]=new Widget();
    trace<<"\nnew Widget"<<endl;
    widd[1]=new Widget();
    trace<<"\nnew Widget"<<endl;
    widd[2]=new Widget();
    trace<<"\nnew Widget"<<endl;
    widd[3]=new Widget();
    trace<<"\nnew Vector Widget"<<endl;

    trace<<"\ndelete Widget"<<endl;
    delete wid[0];
    trace<<"\ndelete Widget"<<endl;
    delete wid[1];
    trace<<"\ndelete Widget"<<endl;
    delete wid[2];
    trace<<"\ndelete Widget"<<endl;
    delete wid[3];
    trace<<"\ndelete Vector Widget"<<endl;
    delete[] vwid;

    trace<<"\ndelete Widget"<<endl;
    delete widd[0];
    trace<<"\ndelete Widget"<<endl;
    delete widd[1];
    trace<<"\ndelete Widget"<<endl;
    delete widd[2];
    trace<<"\ndelete Widget"<<endl;
    delete widd[3];
    return 0;
}
