#ifndef PARSER_HXX
#define PARSER_HXX
#include <map>
#include <string>

extern std::map<std::string,double> table;

double prim(bool, Symbol* s);
double term(bool, Symbol* s);
double expr(bool, Symbol* s);

#endif