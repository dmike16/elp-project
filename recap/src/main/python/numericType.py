#! /usr/bin/env python3.4
# Numeric Type Example

a = 3
b = 4
print(a + 1, b**2, a % 2, b//3)
print('%e' % (b / 89))
print('%4.2f' % (b / 89))
print('{0:4.2f}'.format(a/89))
print(a < b, a == b, a < b/3 < 10)
print(5/2, -5/2, -5/2.0)
print(5//2, -5//2, -5//2.0)

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
