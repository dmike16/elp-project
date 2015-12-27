#include "secure.hpp"
#include "crypto.hpp"

void secure::encryptMes()
{
	using crypto::Xor;

	Xor::enDeCrypt();
}
