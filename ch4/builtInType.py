#!/usr/bin/env python
#
# Author dmike
#

print('Built-In Type Example')

print('******** Number ***********')
import math
a =123
b =222
print(a+b)
print(a*b)
print('{:.3f}'.format(b*(a**-1)))
print('{:.3f}'.format(math.pi*2))
print('{:.3f}'.format(math.sqrt(a)))

import random
print('{:.3f}'.format(random.random()))

print('********** Strings *********')
S='Spam'
print(len(S))
print(S[0])
print(S[-1])
print(S[1:3])

coord ='xyz'
print(S+coord)
print(S*4)

S= 'x' + S
print(S)

L =list(S)
print(L)
L[1] = 'x'
print(''.join(L))
print(S)

B =bytearray(b'Spam')
B.extend(b'mem')
print(B.decode())

print(S.find('pa'))
print(S.replace('pa','XYZ'))
print(S)

line ='aa,bbb,cccc,ddd'
print(line.split(','))
print(line.upper())
print(line.isalpha())

line = line + '\n'
print(line)
print(line.rstrip())
print(line.rstrip().split(','))
print('{0}, bella, {1}'.format(S,line))
msg = """
AAAaaaa
bbbbbb
vvvvvv
"""
u2=u'sp\xc4m'
b=b'a\x01c'
u1='sp\xc4m'
print(msg)
print (u2,u1,b)

import re
match =re.match('Hello[ \t](.*)world','Hello  Python world')
print (match.group(1))

print('************ LISTS **********')

L =[123,'spam', '4m']
print (L)
print (len(L))
print (L + [4,5,6])
print (L*2)
print (L)
L.append('NI')
print (L)
L.pop(2)
print (L)
L.reverse()
print (L)

M=[[1,0,0],
   [0,1,0],
   [0,0,1]]
print (M)

col2 =[row[1] for row in M]
print (col2)
col2_1=[row[1] for row in M if row[1] != 0]
print (col2_1)
print (list(range(4)))

G =(sum(row) for row in M)
print (next(G))
print (list(map(sum,M)))
print({sum(row) for row in M})
print({i:sum(M[i]) for i in range(3)})

print('********** Dictionaries *********')

D = {}
D['name'] = 'Bob'
D['job'] = 'dev'
D['age'] = 40
print(D)

bob1 =dict(name='Bob',job='dev',age='40')
print(bob1)

bob2 =dict(zip(['name','job','age'],['Bob','dev',40]))
print (bob2)

rec = {'name': {'first': 'Bob', 'last': 'Smith'},
'jobs': ['dev', 'mgr'],
'age': 40.5}
print (rec)

rec['jobs'].append('janitor')
print(rec)
if not 'f' in rec:
    print('missing')
