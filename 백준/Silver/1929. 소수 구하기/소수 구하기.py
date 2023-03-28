m, n = map(int, input().split())
nums = [0] * (n + 1)

for i in range(n + 1):
    nums[i] = i

for i in range(2, int(n ** 0.5) + 1):
    if nums[i] == 0:
        continue
    for j in range(i + i, n + 1, i):
        nums[j] = 0

for i in range(m, n + 1):
    if nums[i] != 0 and i != 1:
        print(nums[i])