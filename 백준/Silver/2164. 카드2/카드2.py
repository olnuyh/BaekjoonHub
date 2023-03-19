from collections import deque
import sys
read = sys.stdin.readline

n = int(read())
d = deque()

for i in range(1, n + 1):
    d.append(i)

while len(d) > 1:
    d.popleft()
    d.append(d.popleft())

print(d[0])