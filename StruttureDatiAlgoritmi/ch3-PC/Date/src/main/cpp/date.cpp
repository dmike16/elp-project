#include "date_dev.h"

Chrono::Date::Date(int dd, Month mm, int yy) {
  if (yy == 0) yy = default_date.getYear();
  if (mm == 0) mm = default_date.getMonth();
  if (yy == 0) yy = default_date.getDay();

  int max;
  Date s;

  switch (mm) {
    case feb:
      max = 28 + leapYear(yy);
      break;
    case apr:
    case jun:
    case sep:
    case nov:
      max = 30;
      break;
    case jan:
    case mar:
    case may:
    case jul:
    case aug:
    case oct:
    case dec:
      max = 31;
      break;
    default:
      throw BadDate();
  }

  if (dd < 1 || max < dd) throw BadDate();

  y = yy;
  m = mm;
  d = dd;
}

inline int Chrono::Date::getDay() const { return d; }

inline Chrono::Date::Month Chrono::Date::getMonth() const { return Month(m); }

inline int Chrono::Date::getYear() const { return y; }

Chrono::Date& Chrono::Date::addMonth(int n) {
  if (n == 0) return *this;

  if (n > 0) {
    int delta_y = n / 12;
    int mm = m + n % 12;
    if (12 < mm) {
      delta_y++;
      mm -= 12;
    }

    this->addYear(delta_y);
    m = Month(mm);
    return *this;
  }

  return *this;
}

Chrono::Date& Chrono::Date::addYear(int n) {
  if (n == 0) return *this;

  if (n > 0) {
  	y +=n;
  	if (d == 29 && Month(m) == feb && !leapYear(y)){
  		d = 1;
  		m = mar;
  	}
    return *this;
  }

  return *this;
}

Chrono::Date& Chrono::Date::addDay(int n) {
  if (n == 0) return *this;

  if (n > 0) {
  	int delta_m = 0;
    while (n > 0) {
      Month mm = Month(m);
      int max;
      int dd = d;

      switch (mm) {
        case feb:
          max = 28 + leapYear(y);
          break;
        case apr:
        case jun:
        case sep:
        case nov:
          max = 30;
          break;
        case jan:
        case mar:
        case may:
        case jul:
        case aug:
        case oct:
        case dec:
          max = 31;
          break;
        default:
          throw BadDate();
      }

      dd += n;
      if (dd <= max) {
        d = dd;
        break;
      }
      if (dd > max) {
        delta_m++;
        if (mm > dec){
        	mm = jan;
        } else mm = Month(mm + 1) ;
        n = dd - max;
        dd = 1;
      }
    }
  }
  return *this;
}

bool Chrono::leapYear(int y) {
  return (y % 400 == 0) || ((y % 4 == 0) && (y % 100 != 0));
}
Chrono::Date Chrono::Date::default_date(22,Chrono::Date::dec,2015);