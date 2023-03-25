N, M = map(int, input().split())
L = list(map(int, input().split()))

start = 0
end = 0
for i in L:
    if start < i:
        start = i
    end += i

while start <= end:
    mid = (start + end) // 2
    sum = 0
    count = 0
    for i in range(N):
        if sum + L[i] > mid:
            count += 1
            sum = 0
        sum += L[i]

    if sum != 0:
        count += 1

    if count > M:
        start = mid + 1
    else:
        end = mid - 1

print(start)