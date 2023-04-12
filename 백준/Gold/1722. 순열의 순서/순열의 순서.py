import sys
read = sys.stdin.readline

n = int(read())
inputList = list(map(int, read().split()))
q, l = inputList[0], inputList[1:]
f = [0] * (n + 1)
f[0] = 1
for i in range(1, n + 1):
    f[i] = f[i - 1] * i

if q == 1:
    k = l[0]
    answer = []
    visited = [False] * (n + 1)
    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if visited[j]:
                continue
            if f[n - i] < k:
                k -= f[n - i]
            else:
                answer.append(j)
                visited[j] = True
                break
    for i in answer:
        print(i, end = ' ')
else:
    answer = 0
    visited = [False] * (n + 1)
    for i in range(n):
        for j in range(1, l[i]):
            if visited[j] == 0:
                answer += f[n - i - 1]
        visited[l[i]] = True
    print(answer + 1)