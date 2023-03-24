import sys
sys.setrecursionlimit(10000)
read = sys.stdin.readline

n, m = map(int, read().split())
l = [[] for _ in range(n)]
visited = [False] * n
check = False

def dfs(num, count):
    global check
    if count == 5:
        check = True
        return

    visited[num] = True
    for i in l[num]:
        if not visited[i]:
            dfs(i, count + 1)
    visited[num] = False

for _ in range(m):
    a, b = map(int, read().split())
    l[a].append(b)
    l[b].append(a)

for i in range(n):
    count = 1
    dfs(i, 1)
    if check:
        break

if check:
    print(1)
else:
    print(0)