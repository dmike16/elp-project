#! /usr/bin/env python3.4
# Calculate the min cost of matrix multiplications

n = 4
d = [100, 20, 1000, 2, 50]
row = [0 for i in range(n)]
cost = [list(row) for i in range(n)]
row = [-1 for i in range(n)]
index = [list(row) for i in range(n)]

for diag in range(1, n):
    for i in range(0, n - diag):
        j = i + diag
        cost[i][j] = 'inf'
        for r in range(i, j):
            cost_temp = cost[i][r] + cost[r + 1][j]
            cost_temp = cost_temp + d[i] * d[r + 1] * d[j + 1]
            if (cost[i][j] == 'inf' or cost_temp < cost[i][j]):
                cost[i][j] = cost_temp
                index[i][j] = r

print(cost[0][n - 1])
print(index[0][n - 1])
