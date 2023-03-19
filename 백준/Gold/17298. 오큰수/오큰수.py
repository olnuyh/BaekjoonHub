import sys
read = sys.stdin.readline

n = int(read())
l = list(map(int, read().split()))

s = []
answer = [0] * n

for i in range(n):
    while s and l[s[-1]] < l[i]:
        answer[s.pop()] = l[i]

    s.append(i)

while s:
    answer[s.pop()] = -1

for i in answer:
    print(i, end = ' ')