import sys
read = sys.stdin.readline

n = int(read())
m = int(read())

distance = [[sys.maxsize] * (n + 1) for _ in range(n + 1)]
for i in range(1, n + 1):
    distance[i][i] = 0

for i in range(m):
    a, b, c = map(int, read().split())
    if distance[a][b] != sys.maxsize:
        distance[a][b] = min(distance[a][b], c)
    else:
        distance[a][b] = c

for k in range(1, n + 1):
    for start in range(1, n + 1):
        for end in range(1, n + 1):
            distance[start][end] = min(distance[start][end], distance[start][k] + distance[k][end])

for i in range(1, n + 1):
    for j in range(1, n + 1):
        if distance[i][j] == sys.maxsize:
            distance[i][j] = 0
    del distance[i][0]
    for j in distance[i]:
        print(j, end = ' ')
    print()