from collections import deque

n = int(input())
m = int(input())
route = [[] for _ in range(n + 1)]
reverse_route = [[] for _ in range(n + 1)]
indegree = [0] * (n + 1)

for i in range(m):
    s, e, h = map(int, input().split())
    route[s].append((e, h))
    indegree[e] += 1
    reverse_route[e].append((s, h))

start, end = map(int, input().split())

queue = deque()
queue.append(start)
time = [0] * (n + 1)

while queue:
    now = queue.popleft()
    for next in route[now]:
        time[next[0]] = max(time[next[0]], time[now] + next[1])
        indegree[next[0]] -= 1
        if indegree[next[0]] == 0:
            queue.append(next[0])

queue.append(end)
visited = [False] * (n + 1)
visited[end] = True
road = 0

while queue:
    now = queue.popleft()
    for next in reverse_route[now]:
        if time[next[0]] + next[1] == time[now]:
            road += 1
            if not visited[next[0]]:
                visited[next[0]] = True
                queue.append(next[0])

print(time[end])
print(road)