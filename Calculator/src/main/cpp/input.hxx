#ifndef INPUT_HXX
#define INPUT_HXX
#include <string>

enum Token_Value {
  NAME,
  NUMBER,
  END,
  PLUS = '+',
  MINUS = '-',
  MUL = '*',
  DIV = '/',
  PRINT = ';',
  ASSIGN = '=',
  LB = '(',
  RB = ')'
};

struct Symbol {
  double number_value;
  std::string string_value;
};

extern Token_Value curr_token;

Token_Value get_token(Symbol* s);
#endif