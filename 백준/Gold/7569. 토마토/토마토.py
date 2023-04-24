from collections import deque
import sys
read = sys.stdin.readline

m, n, h = map(int, read().split())
tomatoes = [[list(map(int, read().split())) for _ in range(n)] for _ in range(h)]

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

q = deque()

def BFS():
    while q:
        nowZ, nowX, nowY = q.popleft()
        for i in range(6):
            nextZ = nowZ + dz[i]
            nextX = nowX + dx[i]
            nextY = nowY + dy[i]
            if 0 <= nextX < n and 0 <= nextY < m and 0 <= nextZ < h:
                if tomatoes[nextZ][nextX][nextY] == 0:
                    tomatoes[nextZ][nextX][nextY] = tomatoes[nowZ][nowX][nowY] + 1
                    q.append((nextZ, nextX, nextY))

for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomatoes[i][j][k] == 1:
                q.append((i, j, k))

BFS()

flag = False
result = 0
for i in range(h):
    for j in range(n):
        for k in range(m):
            if tomatoes[i][j][k] == 0:
                flag = True
            result = max(result, tomatoes[i][j][k])

if flag:
    print(-1)
elif result == 1:
    print(0)
else:
    print(result - 1)