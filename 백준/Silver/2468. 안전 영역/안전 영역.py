from collections import deque

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

n = int(input())
area = [list(map(int, input().split())) for _ in range(n)]
answer = []

def BFS(r, c, h):
    q = deque()
    q.append((r, c))
    visited[r][c] = 1
    while q:
        nowR, nowC = q.popleft()
        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < n and 0 <= nextC < n:
                if not visited[nextR][nextC] and area[nextR][nextC] > h:
                    q.append((nextR, nextC))
                    visited[nextR][nextC] = 1
    return 1

for h in range(101):
    visited = [[0] * n for _ in range(n)]
    result = []
    for i in range(n):
        for j in range(n):
            if area[i][j] > h and not visited[i][j]:
                result.append(BFS(i, j, h))

    if len(result) == 0:
        break
    else:
        answer.append(sum(result))

print(max(answer))