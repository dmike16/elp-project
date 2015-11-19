#include <string>
#include <iostream>

namespace sort {
void makeSort(int *, int, std::string);
void insectioSort(int *, int, int);
void mergeSort(int *, int, int, int, int *);
void quickSort(int *, int, int, int);
}

namespace {
const int LIMIT_1 = 7;
const int LIMIT_2 = 40;

int swap_cnt = 0;

struct _ {
  int sx;
  int cx;
  int dx;
} pos;
inline int static_min(int a, int b) { return (a < b) ? a : b; }
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
void static_swap(int *x, int a, int b, int r) {
  int _a = a, _b = b;
  if (r > 0) {
    do {
      int temp = x[_b];
      x[_b++] = x[_a];
      x[_a++] = temp;
    } while (--r > 0);
  }
}
int static_median(int *x, int sx, int cx, int dx) {

  return (x[sx] < x[cx]) ? (x[cx] < x[dx]) ? cx : (x[sx] < x[dx]) ? dx : sx
                         : (x[dx] < x[cx]) ? cx : (x[sx] < x[dx]) ? sx : dx;
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
  int pcx;
loop:
  if (n <= LIMIT_1) {
    return insectioSort(x, dx + 1, sx);
  }
  pcx = (sx + dx) / 2;
  if (n > LIMIT_1) {
    int psx = sx;
    int pdx = dx;

    if (n > LIMIT_2) {
      int d = n / 8;
      psx = static_median(x, psx, psx + d, psx + 2 * d);
      pcx = static_median(x, pcx - d, pcx, pcx + d);
      pdx = static_median(x, pdx - 2 * d, pdx - d, pdx);
    }

    pcx = static_median(x, psx, pcx, pdx);
  }

  static_swap(x, sx, pcx, 1);

  int i = sx + 1;
  int j = dx;
  int item = x[sx];
  int l = i, m = j;

  while (1) {
    while ((i <= j) && (x[i] <= item)) {
      if (x[i] == item) {
        static_swap(x, l, i, 1);
        l++;
      }
      i++;
    }
    while ((i <= j) && (x[j] >= item)) {
      if (x[j] == item) {
        static_swap(x, j, m, 1);
        m--;
      }
      j--;
    }

    if (i > j)
      break;

    static_swap(x, i, j, 1);
    i++;
    j--;
  }
  int r = static_min(i - l, l - sx);
  static_swap(x, sx, i - r, r);

  r = static_min(dx - m, m - j);
  static_swap(x, i, dx + 1 - r, r);

  int rl = i - l, rr = m - j;

  if (rl < rr) {
    if (rl > 1) {
      quickSort(x, rl, sx, sx + rl);
    }
    if (rr > 1) {
      sx = dx + 1 - rr;
      n = rr;
      goto loop;
    }
  } else {
    if (rr > 1)
      quickSort(x, rr, dx + 1 - rr, dx);
    if (rl > 1) {
      dx = sx + rl;
      n = rl;
      goto loop;
    }
  }
}
