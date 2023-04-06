import sys
read = sys.stdin.readline

n, m = map(int, read().split())
strList = set([read() for _ in range(n)])
answer = 0

for _ in range(m):
    word = read()
    if word in strList:
        answer += 1

print(answer)