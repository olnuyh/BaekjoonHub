import sys
read = sys.stdin.readline

n = int(read())
D = [[1] * 10 for _ in range(n + 1)]
D[1][0] = 0
for i in range(2, n + 1):
    D[i][0] = D[i - 1][1]
    D[i][9] = D[i - 1][8]
    for j in range(1, 9):
        D[i][j] = D[i - 1][j - 1] + D[i - 1][j + 1]
s = 0
for i in range(10):
    s += D[n][i]
print(s % 1000000000)