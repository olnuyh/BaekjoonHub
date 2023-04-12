D = [[0] * 31 for _ in range(31)]
for i in range(1, 31):
    D[i][0] = 1
    D[i][i] = 1
    D[i][1] = i

for i in range(3, 31):
    for j in range(2, 31):
        D[i][j] = D[i - 1][j - 1] + D[i - 1][j]

T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    print(D[m][n])