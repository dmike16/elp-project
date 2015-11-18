#include <iostream>
#include <cstdlib>
#include <ctime>
#include "Sort.h"

using namespace std;
using sort::makeSort;

void generate_vector(int *x, int n) {

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
  int x[1610000];
  int n = 1610000;
  clock_t cpu0, cpu1;

  srand(time(0));

  generate_vector(x, n);
  cout << "Vector not ordered" << endl;
  // display_vector(x, n);

  cpu0 = clock();
  // makeSort(x, n, "insectionmakeSort");
  cpu1 = clock();

  cout << "Vector ordered Inserction Sort in "
       << (float)(cpu1 - cpu0) / CLOCKS_PER_SEC << endl;
  // display_vector(x, n);

  generate_vector(x, n);
  cout << "Vector not ordered" << endl;
  // display_vector(x, n);

  cpu0 = clock();
  // makeSort(x, n, "mergemakeSort");
  cpu1 = clock();
  cout << "Vector ordered Merge Sort in "
       << (float)(cpu1 - cpu0) / CLOCKS_PER_SEC << endl;
  // display_vector(x, n);

  generate_vector(x, n);
  cout << "Vector not ordered" << endl;
  // display_vector(x, n);

  cpu0 = clock();
  makeSort(x, n, "quickSort");
  cpu1 = clock();
  cout << "Vector ordered Quick Sort in "
       << (float)(cpu1 - cpu0) / CLOCKS_PER_SEC << endl;
  // display_vector(x, n);
}
