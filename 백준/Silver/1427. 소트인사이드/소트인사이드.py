import sys
read = sys.stdin.readline

l = list(read())

for i in range(len(l)):
    m = 0
    for j in range(i + 1, len(l)):
        if l[j] > l[m]:
            m = j

    if l[i] < l[m]:
        temp = l[i]
        l[i] = l[m]
        l[m]= temp

answer = ''
for i in range(len(l)):
    answer += l[i]

print(int(answer))