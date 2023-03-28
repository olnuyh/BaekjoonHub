a, b = map(int, input().split())
nums = [0] * 10000001

for i in range(2, len(nums)):
    nums[i] = i

for i in range(2, int(len(nums) ** 0.5) + 1):
    if nums[i] == 0:
        continue
    for j in range(2 * i, len(nums), i):
        nums[j] = 0

count = 0
for i in range(2, len(nums)):
    if nums[i] != 0:
        temp = nums[i]
        while nums[i] <= b / temp:
            if nums[i] >= a / temp:
                count += 1
            temp = temp * nums[i]

print(count)