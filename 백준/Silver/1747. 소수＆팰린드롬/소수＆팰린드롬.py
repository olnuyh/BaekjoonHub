n = int(input())
nums = [0] * 10000001

for i in range(2, len(nums)):
    nums[i] = i

for i in range(2, int(len(nums) ** 0.5) + 1):
    if nums[i] == 0:
        continue
    for j in range(2 * i, len(nums), i):
        nums[j] = 0

i = n
while True:
    if nums[i] != 0 and i != 1:
        if str(i)[::-1] == str(i):
                print(nums[i])
                break
    i += 1