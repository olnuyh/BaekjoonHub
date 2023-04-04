import sys
read = sys.stdin.readline

n, m = map(int, read().split())
edge_list = []
for i in range(m):
    a, b, c = map(int, read().split())
    edge_list.append((a, b, c))

distance = [sys.maxsize] * (n + 1)
distance[1] = 0

for _ in range(n - 1):
    for start, end, weight in edge_list:
        if distance[start] != sys.maxsize and distance[end] > distance[start] + weight:
            distance[end] = distance[start] + weight

cycle = False

for start, end, weight in edge_list:
    if distance[start] != sys.maxsize and distance[end] > distance[start] + weight:
        cycle = True
        break

if cycle:
    print(-1)
else:
    for i in range(2, n + 1):
        if distance[i] == sys.maxsize:
            print(-1)
        else:
            print(distance[i])