#include "integerToArray.h"
#include <iostream>

namespace {
  typedef int(*aritmetic)(int,int);
  int tmp_sum(int a,int b){
    return a+b;
  };
  int tmp_diff(int a, int b){
    return a-b;
  };
  const int* tmp_max(const int* x, const int* y, int n){
    for (int i = 1; i <= n; i++){
      if (x[i] != 0 || y[i] != 0){
        if (x[i] > y[i]){
          return x;
        } else if (x[i] < y[i]){
          return y;
        } else continue;
      }
    }
    return x;
  };
  int* static_sum(const int* x, const int* y, int* r, int n){
    aritmetic tmp_operator = (x[0] == y[0])? tmp_sum: tmp_diff;

    const int* max = tmp_max(x, y, n);
    const int* min = (max != x)? x: y;

    for(int i = 2*MAX,carry_over = 0, tmp_r = 0;i > n; i--){
      tmp_r = tmp_operator(max[i - n],min[i - n]);
      if (tmp_r > 9){
        r[i] = (tmp_r % 10) + carry_over;
        carry_over = tmp_r /10;
      } else if (tmp_r < 0){
        r[i] = tmp_operator(10+max[i-n],min[i-n]);
        carry_over = -1;
      } else {
        r[i] = (tmp_r % 10) + carry_over;
        carry_over = 0;
      }
    }

    for(int j = n; j >= 1; j--){
      r[j] = 0;
    }
    r[0] = (max[0] ==-1)? -1: 1;

    return r;
  };
}
// Trasform an Interger in an Array with element equal to integer's digits
int* integerToArray(int x){
  int* n = new int[MAX +1];

  (x < 0)? n[0] = -1, x *= -1: n[0] = 1;
  for (int i = MAX; i >= 1; i--,x /= 10){
    n[i] = x % 10;
  }
  return n;
}

// Sum two Integers in the form of Array Digits
int* sum(const int* x,const int* y, int){
  int* result = new int[2*MAX + 1];

  return static_sum(x,y,result,MAX);
}

// DIsplay Interger in the form of Array Digit
void displayInteger(const int* x, int n, bool clean){
  (x[0] == 1)? std::cout<<"+" : std::cout<<"-";
  bool at_least_one = false;
  for (int i = 1, no_print = 1; i <= n; i++){
    if (no_print && x[i] == 0){
      continue;
    } else {
      at_least_one = true;
      std::cout<<x[i];
      no_print = 0;
    }
  }
  if (!at_least_one){
    std::cout<<"0";
  }
  std::cout<<"\n";

  if (clean){
    delete x;
  }
}
