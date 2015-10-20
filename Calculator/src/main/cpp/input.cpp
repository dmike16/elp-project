#include <iostream>
#include <cctype>
#include "input.hxx"
#include "error.hxx"

using namespace std;

Token_Value curr_token = PRINT;

Token_Value get_token(Symbol* s) {
  char ch;

  do {
    if (!cin.get(ch)) return curr_token = END;
  } while (ch != '\n' && isspace(ch));

  switch (ch) {
    case ';':
    case '\n':
      return curr_token = PRINT;
    case '*':
    case '/':
    case '+':
    case '-':
    case '(':
    case ')':
    case '=':
      return curr_token = Token_Value(ch);
    case '0':
    case '1':
    case '2':
    case '3':
    case '4':
    case '5':
    case '6':
    case '7':
    case '8':
    case '9':
    case '.':
      cin.putback(ch);
      cin >> s->number_value;
      return curr_token = NUMBER;
    default:
      if (isalpha(ch)) {
        s->string_value = ch;
        while (cin.get(ch) && isalnum(ch)) {
          (s->string_value).push_back(ch);
        }
        cin.putback(ch);
        return curr_token = NAME;
      }
      error("bad token");
      return curr_token = PRINT;
  }
}