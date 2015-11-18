#include <string>
#include <iostream>

namespace sort {
void makeSort(int *, int, std::string);
void insectioSort(int *, int, int);
void mergeSort(int *, int, int, int, int *);
void quickSort(int *, int, int, int);
}

namespace {
const int LIMIT = 7;
int swap_cnt = 0;

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
void static_swap(int *x, int a, int b) {
  int temp = x[b];
  x[b] = x[a];
  x[a] = temp;
}
int static_distribution(int *x, int sx, int px, int dx) {
  swap_cnt = 0;
  if (px != dx)
    static_swap(x, px, dx);
  int i = sx;
  int j = dx;
  int item = x[dx];

  while (i < j) {
    while ((i < j) && (x[i] <= item)) {
      i++;
    }
    while ((i < j) && (x[j] >= item)) {
      j--;
    }

    if (i < j) {
      static_swap(x, i, j);
      swap_cnt = 1;
    }
  }
  if (i != dx)
    static_swap(x, i, dx);
  return i;
}
int static_median(int *x, int sx, int dx) {
  int cx = (sx + dx) / 2;

  return (x[sx] < x[cx]) ? ((x[cx] < x[dx]) ? cx : (x[sx] < x[dx]) ? b : a) : ;
}
}

void sort::makeSort(int *x, int n, std::string method) {
  if (method == "insectionmakeSort") {
    return insectioSort(x, n, 0);
  } else if (method == "mergemakeSort") {
    int *b = new int[n];

    mergeSort(x, n, 0, n - 1, b);
    delete b;
  } else {
    return quickSort(x, n, 0, n - 1);
  }
}

void sort::insectioSort(int *x, int n, int sx) {
  for (int i = sx, j = 0, prossimo = 0; i < n; i++) {
    prossimo = x[i];
    j = i;
    while ((j > sx) && (x[j - 1] > prossimo)) {
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

void sort::quickSort(int *x, int n, int sx, int dx) {

loop:
  if (n <= LIMIT) {
    return insectioSort(x, dx + 1, sx);
  }

  if (n > LIMIT) {

    int px = static_median(x, sx, dx);
    int pr = static_distribution(x, sx, px, dx - 1);

    if (swap_cnt == 0)
      return insectioSort(x, dx + 1, sx);

    if (pr - sx > 1) {
      quickSort(x, pr - 1 - sx, sx, pr - 1);
    }
    if (dx - pr > 1) {
      n = dx - pr - 1;
      sx = pr + 1;
      goto loop;
      // quickSort(x, dx - pr - 1, pr + 1, dx);
    }
  }
}
