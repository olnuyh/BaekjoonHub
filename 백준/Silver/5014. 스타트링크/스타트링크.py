from collections import deque

F, S, G, U, D = map(int, input().split())
Building = [0] * (F + 1)

def BFS():
    q = deque()
    q.append(S)
    Building[S] = 1
    while q:
        now = q.popleft()
        if now == G:
            return Building[now] - 1
        for i in [U, -D]:
            next = now + i
            if 1 <= next <= F and Building[next] == 0:
                Building[next] = Building[now] + 1
                q.append(next)
    return 'use the stairs'

print(BFS())