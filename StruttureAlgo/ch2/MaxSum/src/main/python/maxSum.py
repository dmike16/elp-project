#! /usr/bin/env python3.4
# Calculate the max sum in the sequence

seq = [3, -1, -34, 45, -3, 24, 34, 34, -5, 34, 256, -4]
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
