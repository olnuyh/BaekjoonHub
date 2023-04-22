n = int(input())
num = list(map(int, input().split()))
line = []
for i in range(len(num)):
    line.insert(len(line) - num[i], i + 1)
for i in line:
    print(i, end = ' ')