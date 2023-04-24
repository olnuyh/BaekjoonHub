from collections import deque
import sys
read = sys.stdin.readline
n, m = map(int, read().split())
paper = [list(map(int, read().split())) for _ in range(n)]

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def BFS(r, c):
    count = 1
    q = deque()
    q.append((r, c))
    paper[r][c] = group
    while q:
        nowR, nowC = q.popleft()
        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < n and 0 <= nextC < m and paper[nextR][nextC] == 1:
                count += 1
                q.append((nextR, nextC))
                paper[nextR][nextC] = group
    return count

group = 2
result = []

for i in range(n):
    for j in range(m):
        if paper[i][j] == 1:
            result.append(BFS(i, j))
            group += 1

print(group - 2)
if len(result) == 0:
    print(0)
else:
    print(max(result))