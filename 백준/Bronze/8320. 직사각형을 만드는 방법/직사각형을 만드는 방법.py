n = int(input())
D = [0] * 10001
D[1] = 1
D[2] = 2
for i in range(3, n + 1):
    D[i] = D[i - 1]
    for j in range(1, int(i ** 0.5) + 1):
        if i % j == 0:
            D[i] += 1
print(D[n])