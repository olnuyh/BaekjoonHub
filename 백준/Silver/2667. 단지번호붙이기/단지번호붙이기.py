from collections import deque

n = int(input())
myMap = [[] for _ in range(n)]

for i in range(n):
    myMap[i] = list(map(int, input()))

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]

complex = 2

def BFS(a, b):
    q = deque()
    q.append((a, b))
    myMap[a][b] = complex
    while q:
        now_r, now_c = q.popleft()
        for i in range(4):
            next_r = now_r + dr[i]
            next_c = now_c + dc[i]
            if 0 <= next_r < n and 0 <= next_c < n and myMap[next_r][next_c] == 1:
                q.append((next_r, next_c))
                myMap[next_r][next_c] = complex

for i in range(n):
    for j in range(n):
        if myMap[i][j] == 1:
            BFS(i, j)
            complex += 1

print(complex - 2)

house = [0] * complex
for i in range(n):
    for j in range(n):
        if myMap[i][j] != 0:
            house[myMap[i][j]] += 1

house.sort()

for i in house:
    if i != 0:
        print(i)