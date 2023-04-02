n = int(input())
m = int(input())
l = [0] * (n + 1)

def union(a, b):
    a2 = find(a)
    b2 = find(b)
    if a2 != b2:
        l[b2] = a2

def find(a):
    if a == l[a]:
        return a
    else:
        l[a] = find(l[a])
        return l[a]

for i in range(n + 1):
    l[i] = i

for i in range(n):
    t = list(map(int, input().split()))
    for k in range(len(t)):
        if t[k] == 1:
            union(i + 1, k + 1)

route = list(map(int, input().split()))
r = find(route[0])
isPossible = True
for i in range(1, len(route)):
    if find(route[i]) != r:
        isPossible = False
        break

if isPossible:
    print('YES')
else:
    print('NO')