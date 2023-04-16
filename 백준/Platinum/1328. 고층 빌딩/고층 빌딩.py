N, L, R = map(int, input().split())
D = [[[0] * (R + 1) for _ in range(L + 1)] for _ in range(N + 1)]
D[1][1][1] = 1
for i in range(2, N + 1):
    for j in range(1, L + 1):
        for k in range(1, R + 1):
            D[i][j][k] = (D[i - 1][j - 1][k] + D[i - 1][j][k - 1] + D[i - 1][j][k] * (i - 2)) % 1000000007
print(D[N][L][R])