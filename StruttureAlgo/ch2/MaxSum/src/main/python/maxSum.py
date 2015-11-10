#! /usr/bin/env python3.4
# Calculate the max sum in the sequence
import random

seq = []
seq.append(random.randint(1, 100))
for i in range(1, 10):
    seq.append(random.randint(-100, 100))
print(seq)

somma = 0
maxx = somma

for a in seq:
        if somma > 0:
            somma += a
        else:
            somma = a
        if somma > maxx:
            maxx = somma

print('Max summ is: {:,d}'.format(maxx))
