#include <iostream>
#include "error.hxx"

int errors = 0;

double error(const std::string& s) {
  errors++;
  std::cerr << "error" << s << std::endl;
  return 1;
}