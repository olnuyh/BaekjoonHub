n = int(input())
l = [0] * n

for i in range(n):
    l[i] = int(input())

for i in range(n - 1):
    for j in range(n - i - 1):
        if l[j] > l[j + 1]:
            temp = l[j]
            l[j] = l[j + 1]
            l[j + 1] = temp

for i in range(n):
    print(l[i])