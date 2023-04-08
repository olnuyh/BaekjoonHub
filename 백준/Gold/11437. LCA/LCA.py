import sys
from collections import deque
read = sys.stdin.readline
n = int(read())

tree = [[] for _ in range(n + 1)]

for _ in range(n - 1):
    s, e = map(int, read().split())
    tree[s].append(e)
    tree[e].append(s)

parent = [0] * (n + 1)
depth = [0] * (n + 1)
visited = [False] * (n + 1)

def BFS(root):
    queue = deque()
    queue.append(root)
    visited[root] = True
    while queue:
        now = queue.popleft()
        for i in tree[now]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                parent[i] = now
                depth[i] = depth[now] + 1

BFS(1)

def LCA(i, j):
    if depth[i] > depth[j]:
        i, j = j, i
    while depth[i] != depth[j]:
        j = parent[j]
    while i != j:
        i = parent[i]
        j = parent[j]
    return i

m = int(read())
for i in range(m):
    a, b = map(int, read().split())
    print(LCA(a, b))