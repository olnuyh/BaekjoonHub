import sys
read = sys.stdin.readline

n = int(read())
count = [0] * 10001

for i in range(n):
    count[int(read())] += 1

for i in range(10001):
    if count[i] != 0:
        for _ in range(count[i]):
            print(i)