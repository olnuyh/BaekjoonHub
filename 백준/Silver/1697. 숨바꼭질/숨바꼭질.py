from collections import deque

N, K = map(int, input().split())
l = [0] * (100001)

def BFS(pos):
    q = deque()
    q.append(pos)
    while q:
        now = q.popleft()
        if now == K:
            return l[K]
        for next in (now + 1, now - 1, now * 2):
            if 0 <= next <= 100000 and l[next] == 0:
                l[next] = l[now] + 1
                q.append(next)

print(BFS(N))