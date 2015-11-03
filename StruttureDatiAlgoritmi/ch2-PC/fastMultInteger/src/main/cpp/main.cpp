/*
  Implement Fast Integer Mult
  with paradgma divite et impera
*/

#include <iostream>
#include "integerToArray.h"

using namespace std;

const int MAX = 4;
const int MAX_NUMBER = 9999;

int main(){

  cout<< "Calculate x * y"<<endl;
  cout<<"Insert  two integer: ";
  int count = 0;
  int x = 0;
  int* k[2];

  while((count != 2) && (cin >> x)){
    if (x > MAX_NUMBER){
      cout<<"To big max Interger with 4 digits"<<endl;
    } else {
      k[count] = integerToArray(x);
      count++;
    }
  }
  displayInteger(sum(k[0], k[1]),2*MAX,true);
  displayInteger(k[0],MAX,true);
  displayInteger(k[1],MAX,true);

  return 0;
}
