from collections import deque

def BFS(i, j, p):
    q = deque()
    q.append((i, j))
    room[i][j] = 2
    count = 1

    while q:
        nowR, nowC = q.popleft()

        all = True

        for i in range(4):
            nextR = nowR + dr[i]
            nextC = nowC + dc[i]
            if 0 <= nextR < n and 0 <= nextC < m:
                if room[nextR][nextC] == 0:
                    all = False
                    break
        if all: # 현재 칸의 주변 4칸 중 청소되지 않은 빈 칸이 없는 경우
            nextR = nowR - dr[p]
            nextC = nowC - dc[p]
            if nextR < 0 or nextR >= n or nextC < 0 or nextC >= m or room[nextR][nextC] == 1:
                return count
            else:
                q.append((nextR, nextC))
        else:
            for _ in range(4):
                p += 1
                if p == 4:
                    p = 0
                nextR = nowR + dr[p]
                nextC = nowC + dc[p]
                if room[nextR][nextC] == 0:
                    q.append((nextR, nextC))
                    room[nextR][nextC] = 2
                    count += 1
                    break

n, m = map(int, input().split())
r, c, d = map(int, input().split()) # d는 0:북쪽, 1:동쪽, 2:남쪽, 3:서쪽
room = [list(map(int, input().split())) for _ in range(n)]

dr = [-1, 0, 1, 0] # 북, 서, 남, 동(반시계 방향)
dc = [0, -1 , 0, 1]

if d == 3:
    d = 1
elif d == 1:
    d = 3

print(BFS(r, c, d))