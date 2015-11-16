#include <string>

namespace sort {
void makeSort(int *, int, std::string);
void insectioSort(int *, int);
void mergeSort(int *, int, int, int, int *);
}

namespace {
struct _ {
  int sx;
  int cx;
  int dx;
} pos;
void static_merge(int *a, int n, int *b) {
  int i = pos.sx;
  int j = pos.cx + 1;
  int k = 0;
  while ((i <= pos.cx) && (j <= pos.dx)) {
    if (a[i] <= a[j]) {
      b[k] = a[i];
      i++;
    } else {
      b[k] = a[j];
      j++;
    }
    k++;
  }
  for (; i <= pos.cx; i++, k++) {
    b[k] = a[i];
  }
  for (; j <= pos.dx; j++, k++) {
    b[k] = a[j];
  }
  for (i = pos.sx; i <= pos.dx; i++) {
    a[i] = b[i - pos.sx];
  }
}
}

void sort::makeSort(int *x, int n, std::string method) {
  if (method == "insectionmakeSort") {
    return insectioSort(x, n);
  } else if (method == "mergemakeSort") {
    int *b = new int[n];

    mergeSort(x, n, 0, n - 1, b);
    delete b;
  }
}

void sort::insectioSort(int *x, int n) {
  for (int i = 0, j = 0, prossimo = 0; i < n; i++) {
    prossimo = x[i];
    j = i;
    while ((j > 0) && (x[j - 1] > prossimo)) {
      x[j] = x[j - 1];
      j--;
    }
    x[j] = prossimo;
  }
}

void sort::mergeSort(int *x, int n, int sx, int dx, int *b) {
  if (sx < dx) {
    int cx = (sx + dx) / 2;
    mergeSort(x, n, sx, cx, b);
    mergeSort(x, n, cx + 1, dx, b);
    pos.sx = sx, pos.cx = cx, pos.dx = dx;
    static_merge(x, n, b);
  }
}
