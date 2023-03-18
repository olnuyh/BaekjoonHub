from collections import deque
import sys
read = sys.stdin.readline
n, l = map(int, read().split())
nums = list(map(int, read().split()))

d = deque()

for i in range(n):
    while d and d[-1][1] > nums[i]: 
        d.pop()
    d.append((i, nums[i])) 
    if d[0][0] <= i - l:
        d.popleft()
    print(d[0][1], end = ' ')