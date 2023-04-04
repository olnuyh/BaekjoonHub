from queue import PriorityQueue
import sys
read = sys.stdin.readline

n = int(read())
m = int(read())
l = [[] for _ in range(n + 1)]
for i in range(m):
    a, b, c = map(int, read().split())
    l[a].append((b, c))
s, e = map(int, read().split())
distance = [sys.maxsize] * (n + 1)
visited = [False] * (n + 1)

q = PriorityQueue()
q.put((0, s))
distance[s] = 0

while q.qsize() > 0:
    p = q.get()
    if visited[p[1]]:
        continue
    visited[p[1]] = True
    for i in l[p[1]]:
        if distance[i[0]] > p[0] + i[1]:
            distance[i[0]] = p[0] + i[1]
            q.put((distance[i[0]], i[0]))

print(distance[e])