from collections import deque
import sys

read = sys.stdin.readline

V = int(read())
N = [[] for _ in range(V + 1)]
visited = [False] * (V + 1)
distance = [0] * (V + 1)

for _ in range(V):
    nodes = list(map(int, read().split()))
    index = 0
    s = nodes[index]
    index += 1
    while True:
        e = nodes[index]
        if e == -1:
            break
        w = nodes[index + 1]
        N[s].append((e, w))
        index += 2

def BFS(num):
    q = deque()
    q.append(num)
    visited[num] = True

    while q:
        p = q.popleft()
        for i in N[p]:
            if not visited[i[0]]:
                q.append(i[0])
                visited[i[0]] = True
                distance[i[0]] = distance[p] + i[1]

BFS(1)
max = 1
for i in range(2, V + 1):
    if distance[i] > distance[max]:
        max = i

visited = [False] * (V + 1)
distance = [0] * (V + 1)
BFS(max)
distance.sort(reverse = True)
print(distance[0])