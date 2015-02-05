/*
 * =====================================================================================
 *
 *       Filename:  main.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  05/02/2015 18:36:09
 *       Revision:  none
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#include "OStack.hpp"
#include <fstream>
#include <iostream>
#include <string>
using namespace std;

class MyString: public string, public Object{
    public:
        ~MyString(){
            cout<<"deleting string:"<<*this<<endl;
        }
        MyString(string s): string(s){}
};

int main(int argc, char* argv[]){
    if(argc ==2){
        ifstream in(argv[1]);
        Stack text;
        string line;
        while(getline(in,line))
            text.push(new MyString(line));
        MyString* s;
        for(int i=0; i<10; i++){
            if((s=(MyString*)text.pop())==0)break;
            cout<<*s<<endl;
            delete s;
        }
        cout << "Letting the decostructor do the rest:"<<endl;
    }
    else
        cout<<"Wrong nmb Arguments"<<endl;
    return 0;
}
