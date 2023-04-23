T = int(input())
for _ in range(T):
    n = int(input())
    D = [0] * 12
    D[1] = 1
    D[2] = 2
    D[3] = 4
    for i in range(4, n + 1):
        D[i] = D[i - 3] + D[i - 2] + D[i - 1]
    print(D[n])