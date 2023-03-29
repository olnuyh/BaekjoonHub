n = int(input())
materials = [[] for _ in range(n)]
visited = [False] * n
mass = [0] * n
lcm = 1

def gcd(a, b):
    if b == 0:
        return a
    else:
        return gcd(b, a % b)

def DFS(v):
    visited[v] = True
    for i in materials[v]:
        next = i[0]
        if not visited[next]:
            mass[next] = mass[v] * i[2] // i[1]
            DFS(next)

for i in range(n - 1):
    a, b, p, q = map(int, input().split())
    materials[a].append((b, p, q))
    materials[b].append((a, q, p))
    lcm *= p * q // gcd(p, q)

mass[0] = lcm
DFS(0)
g = mass[0]

for i in range(1, n):
    g = gcd(g, mass[i])

for i in range(n):
    print(mass[i] // g, end = ' ')