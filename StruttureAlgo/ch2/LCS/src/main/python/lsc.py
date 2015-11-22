#! /usr/bin/env python3.4
# Find the max common sub sequence

F = 'B,A,A,B,D,C,D,C,A,A,C,A,C,B,A'
S = 'A,D,C,A,A,B'

n = len(S)
m = len(F)
row = [0 for i in range(n + 1)]
LCS = [list(row) for i in range(m + 1)]
row = [[0, 0] for i in range(n + 1)]
index = [list(row) for i in range(m + 1)]

for i in range(1, m + 1):
    for j in range(1, n + 1):
        if (F[i - 1] == S[j - 1]):
            LCS[i][j] = LCS[i - 1][j - 1] + 1
            index[i][j] = [i - 1, j - 1]
        elif (LCS[i][j - 1] > LCS[i - 1][j]):
            LCS[i][j] = LCS[i][j - 1]
            index[i][j] = [i, j - 1]
        else:
            LCS[i][j] = LCS[i - 1][j]
            index[i][j] = [i - 1, j]

print(LCS[m][n])
print(index[m][n])
