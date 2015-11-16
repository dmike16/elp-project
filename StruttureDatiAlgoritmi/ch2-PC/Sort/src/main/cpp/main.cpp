#include <iostream>
#include <cstdlib>
#include <ctime>
#include "Sort.h"

using namespace std;
using sort::makeSort;

void generate_vector(int *x, int n) {
  srand(time(0));

  for (int i = 0; i < n; i++) {
    x[i] = rand() % 100;
  }
}

void display_vector(int *x, int n) {
  cout << "[";
  for (int i = 0; i < n - 1; i++) {
    cout << x[i] << ",";
  }
  cout << x[n - 1] << "]" << endl;
}

int main(void) {
  int x[10];
  int n = 10;

  generate_vector(x, n);
  cout << "Vector not ordered" << endl;
  display_vector(x, n);

  makeSort(x, 10, "insectionmakeSort");

  cout << "Vector ordered Inserction makeSort" << endl;
  display_vector(x, n);

  generate_vector(x, n);
  cout << "Vector not ordered" << endl;
  display_vector(x, n);

  makeSort(x, 10, "mergemakeSort");
  cout << "Vector ordered Merge makeSort" << endl;
  display_vector(x, n);
}
