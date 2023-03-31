from collections import deque
import sys
read = sys.stdin.readline
n, m, k, x = map(int, read().split())
l = [[] for _ in range(n + 1)]
visited = [-1] * (n + 1)
answer = []

for _ in range(m):
    a, b = map(int, read().split())
    l[a].append(b)

def BFS(v):
    q = deque()
    q.append(v)
    visited[v] += 1
    while q:
        p = q.popleft()
        for i in l[p]:
            if visited[i] == -1:
                visited[i] = visited[p] + 1
                q.append(i)

BFS(x)

for i in range(n + 1):
    if visited[i] == k:
        answer.append(i)

if not answer:
    print(-1)
else:
    answer.sort()
    for i in answer:
        print(i)