import sys
read = sys.stdin.readline
sys.setrecursionlimit(100000)
n, m = map(int, read().split())
l = [0] * (n + 1)
tmp = -1

def union(x, y):
    x2 = find(x)
    y2 = find(y)
    if x2 != y2:
        l[y2] = x2

def find(z):
    if z == l[z]:
        return z
    else:
        l[z] = find(l[z])
        return l[z]

for i in range(n + 1):
    l[i] = i

for i in range(m):
    q, a, b = map(int, read().split())
    if q == 0:
        union(a, b)
    else:
        a2 = find(a)
        b2 = find(b)
        if a2 == b2:
            print('YES')
        else:
            print('NO')