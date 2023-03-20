import sys
read = sys.stdin.readline

n = int(read())
l =[]

for i in range(n):
    l.append((int(read()), i))

s = sorted(l)

m = 0

for i in range(n):
    if m < s[i][1] - i:
        m = s[i][1] - i

print(m + 1)
