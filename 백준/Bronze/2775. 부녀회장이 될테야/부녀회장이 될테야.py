T = int(input())
for _ in range(T):
    k = int(input())
    n = int(input())

    Apt = [[0] * (n + 1) for _ in range(k + 1)]
    for i in range(1, n + 1):
        Apt[0][i] = i

    for i in range(1, k + 1):
        for j in range(1, n + 1):
            if j == 1:
                Apt[i][j] = Apt[i - 1][j]
            else:
                Apt[i][j] = Apt[i][j - 1] + Apt[i - 1][j]

    print(Apt[k][n])