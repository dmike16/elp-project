#include <iostream>
#include <map>
#include "input.hxx"
#include "error.hxx"
#include "parser.hxx"

using namespace std;

map<string, double> table;

int main() {
  table["e"] = 2.171828182;
  table["pi"] = 3.14;

  Symbol* s = new Symbol;
  
  while (cin) {
    get_token(s);
    if (curr_token == END) break;
    if (curr_token == PRINT) continue;
    cout << expr(false,s) << endl;
  }

  return errors;
}