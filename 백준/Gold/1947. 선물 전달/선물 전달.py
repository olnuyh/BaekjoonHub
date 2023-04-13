n = int(input())
D = [0] * (n + 2)
D[2] = 1
for i in range(3, n + 1):
    D[i] = (i - 1) * (D[i - 1] + D[i - 2]) % 1000000000

print(D[n])