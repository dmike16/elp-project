#include "input.hxx"
#include "error.hxx"
#include "parser.hxx"

double expr(bool get, Symbol* s) {
  double left = term(get,s);

  for (;;) {
    switch (curr_token) {
      case PLUS:
        left += term(true,s);
        break;
      case MINUS:
        left -= term(true,s);
        break;
      default:
        return left;
    }
  }
}

double term(bool get, Symbol* s) {
  double left = prim(get,s);

  for (;;) {
    switch (curr_token) {
      case MUL:
        left *= prim(true,s);
        break;
      case DIV:
        if (double d = prim(true,s)) {
          left /= d;
          break;
        }
        return error("divide by 0");
      default:
        return left;
    }
  }
}

double prim(bool get, Symbol* s) {
  if (get) get_token(s);

  switch (curr_token) {
    case NUMBER: {
      double v = s->number_value;
      get_token(s);
      return v;
    }
    case NAME: {
      double& v = table[s->string_value];
      if (get_token(s) == ASSIGN) v = expr(true,s);
      return v;
    }
    case MINUS:
      return -prim(true,s);
    case LB: {
      double e = expr(true,s);
      if (curr_token != RB) return error(") expected");
      get_token(s);
      return e;
    }
    default:
      return error("primary expected");
  }
}