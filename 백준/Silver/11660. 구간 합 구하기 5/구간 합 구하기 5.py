import sys
read = sys.stdin.readline

n, m = map(int, read().split())
nums = []
for i in range(n):
    nums.append(list(map(int, read().split())))

s = [[0 for i in range(n + 1)] for j in range(n + 1)]
for i in range(1, n + 1):
   for j in range(1, n + 1):
       s[i][j] = s[i][j - 1] + s[i - 1][j] - s[i - 1][j - 1] + nums[i - 1][j - 1]

for i in range(m):
    x1, y1, x2, y2 = map(int, read().split())
    print(s[x2][y2] - s[x2][y1 - 1] - s[x1 - 1][y2] + s[x1 - 1][y1 - 1])