from collections import deque
n, m = map(int, input().split())
students = [[] for _ in range(n + 1)]
indegree = [0] * (n + 1)
line = []

for i in range(m):
    a, b = map(int, input().split())
    students[a].append(b)
    indegree[b] += 1

queue = deque()
for i in range(1, n + 1):
    if indegree[i] == 0:
        queue.append(i)

while queue:
    p = queue.popleft()
    line.append(p)
    for i in students[p]:
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

for i in line:
    print(i, end = ' ')