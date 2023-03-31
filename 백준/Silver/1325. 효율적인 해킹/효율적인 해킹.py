from collections import deque
import sys
read = sys.stdin.readline

n, m = map(int, read().split())
l = [[] for _ in range(n + 1)]
answer = [0] * (n + 1)

for _ in range(m):
    a, b = map(int, read().split())
    l[a].append(b)

def BFS(v):
    q = deque()
    q.append(v)
    visited[v] = True
    while q:
        p = q.popleft()
        for i in l[p]:
            if not visited[i]:
                answer[i] += 1
                q.append(i)
                visited[i] = True

for i in range(1, n + 1):
    visited = [False] * (n + 1)
    BFS(i)

maxVal = max(answer)
for i in range(1, n + 1):
    if maxVal == answer[i]:
        print(i, end = ' ')