import sys
read = sys.stdin.readline

n = int(read())
T = [0] * (n + 1)
P = [0] * (n + 1)
D = [0] * (n + 2)

for i in range(1, n + 1):
    T[i], P[i] = map(int, read().split())

for i in range(n, 0, -1):
    if i + T[i] > n + 1:
        D[i] = D[i + 1]
    else:
        D[i] = max(D[i + 1], D[i + T[i]] + P[i])

print(D[1])