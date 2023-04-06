import sys
read = sys.stdin.readline
sys.setrecursionlimit(1000000)

n = int(read())
l = [[] for _ in range(n + 1)]
for i in range(n - 1):
    s, e = map(int, read().split())
    l[s].append(e)
    l[e].append(s)

visited = [False] * (n + 1)
parent = [0] * (n + 1)

def DFS(i):
    if not visited[i]:
        visited[i] = True
        for j in l[i]:
            if not visited[j]:
                parent[j] = i
                DFS(j)

DFS(1)
for i in range(2, n + 1):
    print(parent[i])