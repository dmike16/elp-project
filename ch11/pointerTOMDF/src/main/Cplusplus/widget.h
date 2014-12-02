#ifndef WIDGET_H
#define WIDGET_H
#include <iostream>

class Widget
{
public:
    Widget(){
        fptr[0]= &Widget::f;
        fptr[1]= &Widget::g;
        fptr[2]= &Widget::h;
        fptr[3]= &Widget::i;
       }
    void select (int i,int j){
        if(i<0 || i>=cnt) return;
        (this->*fptr[i])(j);
    }
    static int count(){return cnt;}

private:
    void f(int) const {std::cout<<"Widget f\n";}
    void g(int) const {std::cout<<"Widget g\n";}
    void h(int) const {std::cout<<"Widget h\n";}
    void i(int) const {std::cout<<"Widget i\n";}
    static const int cnt =4;
    void (Widget::*fptr[cnt])(int) const;
};

#endif // WIDGET_H
