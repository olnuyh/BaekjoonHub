n = int(input())
v = int(input())
computers = [[] for _ in range(n + 1)]
visited = [False] * (n + 1)

def dfs(num):
    visited[num] = True
    for i in computers[num]:
        if not visited[i]:
            visited[i] = True
            dfs(i)

for i in range(v):
    s, e = map(int, input().split())
    computers[s].append(e)
    computers[e].append(s)

dfs(1)
print(sum(visited) - 1)