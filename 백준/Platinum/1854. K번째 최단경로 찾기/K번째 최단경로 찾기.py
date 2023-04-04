import heapq
import sys
read = sys.stdin.readline

n, m, k = map(int, read().split())
l = [[] for _ in range(n + 1)]
for i in range(m):
    a, b, c = map(int, read().split())
    l[a].append((b, c))

distance = [[sys.maxsize] * k for _ in range(n + 1)]

q = [(0, 1)]
distance[1][0] = 0

while q:
    cost, node = heapq.heappop(q)
    for next_node, next_cost in l[node]:
        new_cost = cost + next_cost
        if distance[next_node][k - 1] > new_cost:
            distance[next_node][k - 1] = new_cost
            distance[next_node].sort()
            heapq.heappush(q, (new_cost, next_node))

for i in range(1, n + 1):
    if distance[i][k - 1] == sys.maxsize:
        print(-1)
    else:
        print(distance[i][k - 1])