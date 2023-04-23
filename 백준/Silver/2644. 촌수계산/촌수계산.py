from collections import deque

n = int(input())
a, b = map(int, input().split())
m = int(input())
family = [[] for _ in range(n + 1)]
for _ in range(m):
    parent, child = map(int, input().split())
    family[parent].append(child)
    family[child].append(parent)

def BFS(num):
    q = deque()
    q.append(num)
    visited[num] = True

    while q:
        now = q.popleft()
        for i in family[now]:
            if not visited[i]:
                result[i] = result[now] + 1
                q.append(i)
                visited[i] = True

visited = [False] * (n + 1)
result = [0] * (n + 1)
BFS(a)
if result[b] == 0:
    print(-1)
else:
    print(result[b])