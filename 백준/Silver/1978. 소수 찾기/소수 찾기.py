n = int(input())
nums = list(map(int, input().split()))
count = 0
for i in nums:
    c = 0
    if i > 1:
        for j in range(2, i):
            if i % j == 0:
                c += 1

        if c == 0:
            count += 1

print(count)