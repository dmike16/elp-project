#ifndef CRYPTO_H
#define CRYPTO_H

namespace crypto {
class Xor {
public:
static void enDeCrypt();
private:
const char key;
static Xor singleton;
Xor();
Xor(const Xor& x);
};
}

#endif
