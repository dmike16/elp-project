#ifndef DATE_H
#define DATE_H

#include <string>

namespace Chrono {
	class Date {
		public:
			enum Month{jan = 1, feb, mar, apr, may, jun, jul, aug, sep, oct, nov, dec};
			class BadDate{};

			Date(int dd =0, Month mm = Month(0), int yy = 0);

			int getDay() const;
            Month getMonth() const;
            int getYear() const;

			std::string toString() const;
			static void setDefault(int, Month, int);

			Date& addYear(int n);
			Date& addMonth(int n);
			Date& addDay(int n);

		private:
			int d, m, y;
			static Date default_date;
	};
}	


#endif // DATE_H
