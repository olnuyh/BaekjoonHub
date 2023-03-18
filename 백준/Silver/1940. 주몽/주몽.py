import sys
read = sys.stdin.readline

n = int(read())
m = int(read())
materials = list(map(int, read().split()))
materials.sort()

start_idx = 0
end_idx = n - 1
count = 0

while start_idx != end_idx:
    s = materials[start_idx] + materials[end_idx]
    if s == m:
        count += 1
        start_idx += 1
    elif s > m:
        end_idx -= 1
    else:
        start_idx += 1

print(count)