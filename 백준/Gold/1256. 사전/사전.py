import sys
read = sys.stdin.readline

n, m, k = map(int, read().split())
D = [[0] * (201) for _ in range(201)]

for i in range(0, 201):
    for j in range(0, i + 1):
        if j == 0 or j == i:
            D[i][j] = 1
        else:
            D[i][j] = D[i - 1][j] + D[i - 1][j - 1]

if D[n + m][m] < k:
    print(-1)
else:
    while not (n == 0 and m == 0):
        if D[n - 1 + m][m] >= k:
            print('a', end = '')
            n -= 1
        else:
            print('z', end = '')
            k -= D[n - 1 + m][m]
            m -= 1