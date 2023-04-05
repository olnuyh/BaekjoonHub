import sys
read = sys.stdin.readline

v, e = map(int, read().split())
edges = []
nodes = [i for i in range(v + 1)]

for i in range(e):
    a, b, c = map(int, read().split())
    edges.append((c, a, b))

edges.sort()

def find(a):
    if a == nodes[a]:
        return a
    else:
        nodes[a] = find(nodes[a])
        return nodes[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        nodes[b] = a

weights = []
for weight, start, end in edges:
    if len(weights) == v - 1:
        break
    if find(start) != find(end):
        union(start, end)
        weights.append(weight)

print(sum(weights))