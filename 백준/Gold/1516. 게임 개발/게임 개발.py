from collections import deque
n = int(input())
time = [0] * (n + 1)
l = [[] for _ in range(n + 1)]
indegree = [0] * (n + 1)
answer = [0] * (n + 1)

for i in range(1, n + 1):
    tmp = list(map(int, input().split()))
    time[i] = tmp[0]
    for j in range(1, len(tmp) - 1):
        l[tmp[j]].append(i)
        indegree[i] += 1

queue = deque()
for i in range(1, n + 1):
    if indegree[i] == 0:
        queue.append(i)

while queue:
    p = queue.popleft()
    for i in l[p]:
        answer[i] = max(answer[i], answer[p] + time[p])
        indegree[i] -= 1
        if indegree[i] == 0:
            queue.append(i)

for i in range(1, n + 1):
    print(answer[i] + time[i])