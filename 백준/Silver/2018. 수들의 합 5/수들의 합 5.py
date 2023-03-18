n = int(input())

start_idx = 0
end_idx = 0
sum = 1
count = 0

while start_idx < n:
    if sum == n:
        count += 1
        sum -= start_idx + 1
        start_idx += 1

    elif sum < n:
        end_idx += 1
        sum += end_idx + 1
    else:
        sum -= start_idx + 1
        start_idx += 1

print(count)