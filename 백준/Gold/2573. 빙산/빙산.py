from collections import deque
import sys
read = sys.stdin.readline

def BFS(r, c):
    q = deque()
    q.append((r, c))
    visited[r][c] = 1

    while q:
        nowR, nowC = q.popleft()

        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < n and 0 <= nextC < m:
                if iceburg[nextR][nextC] == 0:
                    sea[nowR][nowC] += 1
                elif iceburg[nextR][nextC] != 0 and not visited[nextR][nextC]:
                    visited[nextR][nextC] = 1
                    q.append((nextR, nextC))
    return 1

n, m = map(int, read().split())
iceburg = [list(map(int, read().split())) for _ in range(n)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

day = 0
separated = False

while True:
    visited = [[0] * m for _ in range(n)]
    sea = [[0] * m for _ in range(n)]
    count = []
    for i in range(1, n - 1):
        for j in range(1, m - 1):
            if iceburg[i][j] != 0 and not visited[i][j]:
                count.append(BFS(i, j))

    if len(count) == 0:
        break
    elif len(count) >= 2:
        separated = True
        break

    for i in range(1, n - 1):
        for j in range(1, m - 1):
            iceburg[i][j] -= sea[i][j]
            if iceburg[i][j] < 0:
                iceburg[i][j] = 0

    day += 1

if separated:
    print(day)
else:
    print(0)