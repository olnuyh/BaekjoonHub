n = int(input())
D = [1] * (n + 1)
for i in range(3, n + 1):
    D[i] = D[i - 1] + D[i - 2]
print(D[n])