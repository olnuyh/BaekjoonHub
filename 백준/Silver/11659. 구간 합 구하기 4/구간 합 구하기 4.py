import sys
input = sys.stdin.readline
n, m = map(int, input().split())
nums = list(map(int, input().split()))
s = [0]
temp = 0

for i in nums:
    temp += i
    s.append(temp)

for k in range(m):
    i, j = map(int, input().split())
    print(s[j] - s[i - 1])