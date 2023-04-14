n = int(input())
D= [[0] * 2 for _ in range(n + 1)]
D[1][1] = 1
for i in range(2, n + 1):
    D[i][0] = D[i - 1][0] + D[i - 1][1]
    D[i][1] = D[i - 1][0]
print(D[n][0] + D[n][1])