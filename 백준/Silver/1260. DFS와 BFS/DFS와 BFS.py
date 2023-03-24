import sys
from collections import deque
sys.setrecursionlimit(10000)
read = sys.stdin.readline

N, M, V = map(int, read().split())
L = [[] for _ in range(N + 1)]

def DFS(num):
    visited[num] = True
    print(num, end = ' ')
    for i in L[num]:
        if not visited[i]:
            DFS(i)

def BFS(num):
    q = deque()
    q.append(num)
    visited[num] = True

    while q:
        i = q.popleft()
        print(i, end = ' ')
        for j in L[i]:
            if not visited[j]:
                q.append(j)
                visited[j] = True

for i in range(M):
    a, b = map(int, read().split())
    L[a].append(b)
    L[b].append(a)

for i in range(1, N + 1):
    L[i].sort()

visited = [False] * (N + 1)
DFS(V)
print()
visited = [False] * (N + 1)
BFS(V)