from collections import deque

F, S, G, U, D = map(int, input().split())
Building = [0] * (F + 1)
q = deque()
q.append(S)
while q:
    now = q.popleft()
    for i in [U, -D]:
        if i == 0:
            continue
        next = now + i
        if 1 <= next <= F and Building[next] == 0:
            Building[next] = Building[now] + 1
            q.append(next)

if S == G:
    print(0)
else:
    if Building[G] == 0:
        print('use the stairs')
    else:
        print(Building[G])