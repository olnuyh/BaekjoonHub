import sys
read = sys.stdin.readline

n, m, k = map(int, read().split())
length = n
depth = 0
while length != 0:
    length //= 2
    depth += 1

tree = [1] * pow(2, depth + 1)
leafIndex = pow(2, depth)
MOD = 1000000007

for i in range(leafIndex, leafIndex + n):
    tree[i] = int(read())

for i in range(leafIndex - 1, 0, -1):
    tree[i] = tree[2 * i] % MOD * tree[2 * i + 1] % MOD

for _ in range(m + k):
    a, b, c = map(int, read().split())
    if a == 1:
        b += leafIndex - 1
        tree[b] = c
        while b > 0:
            b //= 2
            tree[b] = tree[2 * b] % MOD * tree[2 * b + 1] % MOD
    else:
        start = b + leafIndex - 1
        end = c + leafIndex - 1
        answer = 1
        while start <= end:
            if start % 2 == 1:
                answer = answer * tree[start] % MOD
            if end % 2 == 0:
                answer = answer * tree[end] % MOD
            start = (start + 1) // 2
            end = (end - 1) // 2
        print(answer)