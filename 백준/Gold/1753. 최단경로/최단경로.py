from queue import PriorityQueue
import sys
read = sys.stdin.readline

n, e = map(int, read().split())
s = int(read())
l = [[] for _ in range(n + 1)]

for i in range(e):
    u, v, w = map(int, read().split())
    l[u].append((v, w))

distance = [sys.maxsize] * (n + 1)
distance[s] = 0
visited = [False] * (n + 1)

queue = PriorityQueue()
queue.put((distance[s], s))

while not queue.empty():
    p = queue.get()
    if visited[p[1]]:
        continue
    visited[p[1]] = True
    for i in l[p[1]]:
        if distance[i[0]] > distance[p[1]] + i[1]:
            distance[i[0]] = distance[p[1]] + i[1]
            queue.put((distance[i[0]], i[0]))

for i in range(1, n + 1):
    if visited[i]:
        print(distance[i])
    else:
        print('INF')