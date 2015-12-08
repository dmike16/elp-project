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

# String Method
S = 'spammy'
S = S.replace('mm', 'xx')
print(S)
S = 'xxxxxxSPAMxxxxxSPAM'
# where = S.find('SPAM')
# = S[:where] + 'EGGS' + S[(where + 4):]
print(S.replace('SPAM', 'EGGS', 1))
L = list(S)
L[0] = '2'
print(''.join(L))
S = 'sdsd.sdsd.rr'
print(S.split('.'))
x = 1234
res = 'integers: ....%d....%-6d...%06d' % (x, x, x)
print(res)
print('%f %.2f %.*f' % (1 / 3, 1 / 3, 4, 1 / 3))
reply = """
Bella zio....
cazza %(name)s!
minghia,,,,%(age)s
"""
values = {'name': 'zio', 'age': 345}
print(reply % values)
template = '{0}, {1}, {2}'
print(template.format('spam', 'eggs', 'uova'))
template = '{motto}, {0}, {li}'
print(template.format('ham', motto='03', li='ko'))
template = 'My {1[kind]} rund {0.platform}'
print(template.format(sys, {'kind': 'PC'}))
somelist = list('SPAM')
print('first={0[0]}, lr={0[2]}'.format(somelist))
print('first={0}, last={1}'.format(somelist[0], somelist[-1]))
parts = somelist[0], somelist[-1], somelist[1:3]
print('first{0}, last={1}, midle={2}'.format(*parts))
