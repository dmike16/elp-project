#! /usr/bin/env python3.4
# String Recap

import sys

s = 'abc'
n = 'NI!'

print(sys.argv)

print('-' * 80)
print(s, n * 4)
myjob = 'hacker'
for c in myjob:
    print(c, end=' ')

S = 'spam'
print('\n')
print(S[0], S[-2], S[1:3], S[1:], S[:-1])
print(S[::2], S[::-1])

B = '1101'
I = 0
while B != '':
    I = I << 1
    I += (ord(B[0]) - ord('0'))
    B = B[1:]
print('Number in decimal system: {0:,}'.format(I))
print('-' * 80)
