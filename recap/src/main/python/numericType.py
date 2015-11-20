#! /usr/bin/env python3.4
# Numeric Type Example

import decimal
import fractions

a = 3
b = 4
print(a + 1, b ** 2, a % 2, b // 3)
print('%e' % (b / 89))
print('%4.2f' % (b / 89))
print('{0:4.2f}'.format(a / 89))
print(a < b, a == b, a < b / 3 < 10)
print(5 / 2, -5 / 2, -5 / 2.0)
print(5 // 2, -5 // 2, -5 // 2.0)

c = 3 + 5j
print(c)
bi = 0b10101
oc = 0o025
hx = 0x15
print(bi, oc, hx)
print(bin(21), oct(21), hex(21))
print('{0:o}, {1:x}, {2:b}'.format(21, 21, 21))

x = 1
print(x << 2, bin(x << 2))
print(x | 2, bin(x | 2))
print(x ^ 3, bin(x ^ 3))
print(x & 2, bin(x & 2))
print(x.bit_length(), len(bin(x)) - 2)
y = 'a'
yy = ord(y) ^ ord('*')
print(chr(yy))

# Deciaml
print(0.1 + 0.1 + 0.1 - 0.3)
decimal.getcontext().prec = 2
print(decimal.Decimal(0.1) + decimal.Decimal(0.1) +
      decimal.Decimal(0.1) - decimal.Decimal(0.3))
# Fractions
x = fractions.Fraction(1, 3)
y = fractions.Fraction(5, 3)
print(x, y)
print(x + y, x - y, x * y, x / y)
z = fractions.Fraction(*(2.5).as_integer_ratio())
print(z)
print(float(x))
t = fractions.Fraction.from_float(1 / 3) + y
print(t.limit_denominator(10))

# Sets
xx = set('abcd')
yy = {'b', 'v', 'c', 'f'}
print(xx - yy, xx | yy, xx & yy, xx ^ yy, xx < yy)
xx.add('SPAM')
print(xx)
{x ** 2 for x in [1, 2, 3, 4]}
