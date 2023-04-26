from collections import deque

t = int(input())

def BFS():
    q = deque()
    q.append((start_x, start_y))

    while q:
        x, y = q.popleft()
        if abs(x - end_x) + abs(y - end_y) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                nextX, nextY = conv[i]
                if abs(x - nextX) + abs(y - nextY) <= 1000:
                    q.append((nextX, nextY))
                    visited[i] = 1
    print("sad")
    return

for _ in range(t):
    n = int(input())
    start_x, start_y = map(int, input().split())
    conv = []

    for i in range(n):
        x, y = map(int, input().split())
        conv.append((x, y))
    end_x, end_y = map(int, input().split())
    visited = [0] * n

    BFS()