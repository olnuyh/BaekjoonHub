import sys
read = sys.stdin.readline

n = int(read())
nums = list(map(int, read().split()))

nums.sort()
count = 0

for i in range(n):
    start_idx = 0
    end_idx = n - 1

    while start_idx < end_idx:
        s = nums[start_idx] + nums[end_idx]
        if s == nums[i]:
            if start_idx != i and end_idx != i:    
                count += 1
                break
            elif start_idx == i:
                start_idx += 1
            elif end_idx == i:
                end_idx -= 1
                
        elif s > nums[i]:
            end_idx -= 1
        else:
            start_idx += 1

print(count)