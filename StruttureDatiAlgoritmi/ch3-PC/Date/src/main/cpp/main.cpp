#include "date.hpp"

using namespace std;

int main()
{
	Chrono::Date d;

	cout << d;
	//d.addYear(1);
	//d.addMonth(7);
	d.addDay(365);
	cout << d;

	return 0;
}
