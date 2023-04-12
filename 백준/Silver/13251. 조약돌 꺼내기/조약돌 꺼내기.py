M = int(input())
Count = list(map(int, input().split()))
K = int(input())

sum = 0
for i in Count:
    sum += i

answer = 0
for i in range(len(Count)):
    c = Count[i]
    s = sum
    temp = 1
    for _ in range(K):
        temp *= (c / s)
        c -= 1
        s -= 1
    answer += temp

print(answer)