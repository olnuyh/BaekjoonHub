import sys
read = sys.stdin.readline

n, m = map(int, read().split())
D = [[0] * (m + 1) for _ in range(n + 1)]

answer = 0
for i in range(n):
    numbers = list(read())
    for j in range(m):
        D[i][j] = int(numbers[j])
        if D[i][j] == 1 and i > 0 and j > 0:
            D[i][j] = min(D[i - 1][j - 1], D[i][j - 1], D[i - 1][j]) + 1
        if answer < D[i][j]:
            answer = D[i][j]

print(answer * answer)