#! /usr/bin/env python3.4
# Example of python Sintax
# auhtor dmike
import sys
import testImport  # import all the modue and this name is like a namespace
# from testImport import title  # Copy title

print(sys.platform)
print(testImport.title)
print(dir(testImport))

download = False
print(bool(download))
print(''.join([testImport.title, ' bella']))

data = (x for x in range(10) if (x % 2 == 0))
print(testImport.title.isupper())
print(testImport.title.upper())
print(testImport.title.isupper())

VERSION = 1.0
xml = '''
<?xml version=1.0?>
<Request version="{:,.1f}">
    <Header>
        <Title>{}</Title>
    </Header>
</Request>
'''
# print(xml % (VERSION, testImport.title))
# print(xml.format(VERSION, testImport.title))

# String, List , Dict and Tuple Example
#
S = 'spam'
print(len(S))
print(S[0:3])
L = list(S)
L[1] = 'b'
print(''.join(L))
B = bytearray(b'spam')
B.extend(b'med')
print(B.decode())
Su = 'x'.encode() + b'y'
print(Su)
M = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]
G = (sum(row) for row in M)
print(list(map(sum, M)))
D = {'age': 40, 'job': 'dev', 'name': 'bob'}
D1 = dict(name='Bob', age=40, job='dev')
D2 = dict(zip(['name', 'age', 'job'], ['Bob', 40, 'dev']))
print(D2)
D = 0
if 'age' in D2:
    print('okay')
else:
    print('Missing')
print(D2.get('c', 0))
print(D2['job'] if 'job' in D2 else 0)
