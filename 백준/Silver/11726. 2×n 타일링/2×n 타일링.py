import sys
read = sys.stdin.readline

n = int(read())
D = [1] * (n + 1)
for i in range(2, n + 1):
    D[i] = D[i - 1] + D[i - 2]
print(D[n] % 10007)