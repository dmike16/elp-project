/*
 * =====================================================================================
 *
 *       Filename:  Fname.cpp
 *
 *    Description:  
 *
 *        Version:  1.0
 *        Created:  18/01/2015 19:42:05
 *       Revision:  git
 *       Compiler:  gcc
 *
 *         Author:  Michele Cipolla (), cipmiky@gmail.com
 *   Organization:  ddm
 *
 * =====================================================================================
 */

#include <iostream>
#include <fstream>
#include <string>
using namespace std;

class FName2 : public ifstream {
    public:
        FName2(): named(false){}
        FName2(const string& fname): ifstream(fname.c_str()),
        fileName(fname){
            named=true;
        }
        string name() const {return fileName;}
        void name(const string& newName){
            if(named) return;
            fileName = newName;
            named = true;
        }
    private:
        string fileName;
        bool named;
}; 

int main() {
   FName2 file("FName2.cpp");
  cout << "name: "<<file.name() <<endl;
  string s;
  getline(file,s);
  file.seekg(-200, ios::end);
  file.close();
}
