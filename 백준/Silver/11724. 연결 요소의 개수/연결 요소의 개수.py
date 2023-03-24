import sys
sys.setrecursionlimit(10000)

read = sys.stdin.readline
n, m = map(int, read().split())
l = [[] for i in range(n + 1)]
for i in range(m):
    u, v = map(int, read().split())
    l[u].append(v)
    l[v].append(u)

visit = [False for i in range(n + 1)]

def dfs(k):
    if not visit[k]:
        visit[k] = True

    for i in l[k]:
        if not visit[i]:
            dfs(i)

count = 0
for i in range(1, n + 1):
    if not visit[i]:
        dfs(i)
        count += 1

print(count)