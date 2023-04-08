from collections import deque
import sys
import math
read = sys.stdin.readline

n = int(read())
tree = [[] for _ in range(n + 1)]
for _ in range(n - 1):
    s, e = map(int, read().split())
    tree[s].append(e)
    tree[e].append(s)

kmax = math.ceil(math.log2(n))
depth = [0] * (n + 1)
visited = [False] * (n + 1)
parent = [[0] * (n + 1) for _ in range(kmax + 1)]

def BFS(node):
    queue = deque()
    queue.append(node)
    visited[node] = True
    while queue:
        now = queue.popleft()
        for i in tree[now]:
            if not visited[i]:
                visited[i] = True
                queue.append(i)
                parent[0][i] = now
                depth[i] = depth[now] + 1

BFS(1)

for i in range(1, kmax + 1):
    for j in range(1, n + 1):
        parent[i][j] = parent[i - 1][parent[i - 1][j]]

def LCA(i, j):
    if depth[i] > depth[j]:
        i, j = j, i
    for k in range(kmax, -1, -1):
        if pow(2, k) <= depth[j] - depth[i]:
            j = parent[k][j]

    if i == j:
        return i

    for k in range(kmax, -1, -1):
        if parent[k][i] != parent[k][j]:
            i = parent[k][i]
            j = parent[k][j]
    return parent[0][i]

m = int(read())
for _ in range(m):
    a, b = map(int, read().split())
    print(LCA(a, b))