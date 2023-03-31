from collections import deque

abc_maximum = list(map(int, input().split()))
sender = [0, 0, 1, 1, 2, 2]
receiver = [1, 2, 0, 2, 0, 1]
ab = [[False] * 201 for _ in range(201)]
c = [False] * 201

def BFS():
    q = deque()
    q.append((0, 0))
    ab[0][0]= True
    c[abc_maximum[2]] = True
    while q:
        p = q.popleft()
        x = p[0]
        y = p[1]
        z = abc_maximum[2] - x - y
        for i in range(6):
            xyz = [x, y, z]
            xyz[receiver[i]] += xyz[sender[i]]
            xyz[sender[i]] = 0
            if xyz[receiver[i]] > abc_maximum[receiver[i]]:
                xyz[sender[i]] = xyz[receiver[i]] - abc_maximum[receiver[i]]
                xyz[receiver[i]] = abc_maximum[receiver[i]]
            if not ab[xyz[0]][xyz[1]]:
                q.append((xyz[0], xyz[1]))
                ab[xyz[0]][xyz[1]] = True
                if xyz[0] == 0:
                    c[xyz[2]] = True

BFS()

for i in range(len(c)):
    if c[i]:
        print(i, end = ' ')