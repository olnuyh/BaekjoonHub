from collections import deque
dx = [0, 1, 0, -1]
dy = [1, 0, -1, 0]

n, m = map(int, input().split())
l = []
visited = [[False] * m for _ in range(n)]
for i in range(n):
    l.append(list(map(int, input())))

def BFS(x, y):
    q = deque()
    q.append((x, y))
    visited[x][y] = True
    while q:
        tmp = q.popleft()
        for i in range(4):
            nx = tmp[0] + dx[i]
            ny = tmp[1] + dy[i]
            if nx >= 0 and ny >= 0 and nx < n and ny < m:
                if l[nx][ny] == 1 and not visited[nx][ny]:
                    q.append((nx, ny))
                    visited[nx][ny] = True
                    l[nx][ny] = l[tmp[0]][tmp[1]] + 1
BFS(0, 0)
print(l[n - 1][m - 1])