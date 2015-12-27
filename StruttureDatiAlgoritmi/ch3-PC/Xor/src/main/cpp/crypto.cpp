#include "crypto.hpp"
#include <cctype>
#include <cstdio>
#include <iostream>

using namespace std;

crypto::Xor::Xor() : key('*')
{
}
crypto::Xor::Xor(const Xor& x) : key('*')
{
}
crypto::Xor crypto::Xor::singleton;

void crypto::Xor::enDeCrypt()
{
	int orig_char, new_char;

	while ((orig_char = cin.get()) != EOF) {
		new_char = orig_char ^ Xor::singleton.key;
		if (isprint(orig_char) && isprint(new_char))
			cout.put(new_char);
		else cout.put(orig_char);
	}
}
