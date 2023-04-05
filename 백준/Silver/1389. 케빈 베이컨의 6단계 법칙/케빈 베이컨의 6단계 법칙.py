import sys
read = sys.stdin.readline

n, m = map(int, read().split())
distance = [[sys.maxsize] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    distance[i][i] = 0

for i in range(m):
    a, b = map(int, read().split())
    distance[a][b] = 1
    distance[b][a] = 1

for k in range(1, n + 1):
    for start in range(1, n + 1):
        for end in range(1, n + 1):
            if distance[start][end] > distance[start][k] + distance[k][end]:
                distance[start][end] = distance[start][k] + distance[k][end]

answer = 0
min = sys.maxsize
for i in range(1, n + 1):
    sum = 0
    for j in range(1, n + 1):
        sum += distance[i][j]
    if min > sum:
        min = sum
        answer = i

print(answer)