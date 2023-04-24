from collections import deque
import sys
read = sys.stdin.readline

def BFS():
    while q_fire:
        nowR, nowC = q_fire.popleft()
        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < r and 0 <= nextC < c:
                if maze[nextR][nextC] != '#' and visited_fire[nextR][nextC] == 0:
                    visited_fire[nextR][nextC] = visited_fire[nowR][nowC] + 1
                    q_fire.append((nextR, nextC))

    while q_jihoon:
        nowR, nowC = q_jihoon.popleft()
        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < r and 0 <= nextC < c:
                if maze[nextR][nextC] != '#' and visited_jihoon[nextR][nextC] == 0:
                    if visited_fire[nextR][nextC] == 0 or visited_fire[nextR][nextC] > visited_jihoon[nowR][nowC] + 1:
                        visited_jihoon[nextR][nextC] = visited_jihoon[nowR][nowC] + 1
                        q_jihoon.append((nextR, nextC))
            else:
                return visited_jihoon[nowR][nowC]
    return 'IMPOSSIBLE'

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

r, c = map(int, input().split())
maze = []

visited_jihoon = [[0] * c for _ in range(r)]
visited_fire = [[0] * c for _ in range(r)]

q_jihoon = deque()
q_fire = deque()

for i in range(r):
    tmp = list(input())
    maze.append(tmp)
    for j in range(c):
        if maze[i][j] == 'J':
            q_jihoon.append((i, j))
            visited_jihoon[i][j] = 1
        if maze[i][j] == 'F':
            q_fire.append((i, j))
            visited_fire[i][j] = 1
print(BFS())