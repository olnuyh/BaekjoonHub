import sys
read = sys.stdin.readline

n, m = map(int, read().split())

length = n
depth = 0
while length != 0 :
    length //= 2
    depth += 1

tree = [0] * pow(2, depth + 1)
leafIndex = pow(2, depth)
for i in range(leafIndex, leafIndex + n):
    tree[i] = int(read())

for i in range(leafIndex - 1, 0, -1):
    tree[i] = min(tree[2 * i], tree[2 * i + 1])

for i in range(m):
    a, b = map(int, read().split())
    start = a + leafIndex - 1
    end = b + leafIndex - 1
    answer = []
    while start <= end:
        if start % 2 == 1:
            answer.append(tree[start])
        if end % 2 == 0:
            answer.append(tree[end])
        start = (start + 1) // 2
        end = (end - 1) // 2
    print(min(answer))