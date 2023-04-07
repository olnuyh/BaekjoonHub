import sys
import math
read = sys.stdin.readline
n, m, k = map(int, read().split())
d = math.ceil(math.log2(n))
tree = [0] * (2 ** d * 2)

for i in range(2 ** d, 2 ** d + n):
    tree[i] = int(read())

for i in range(2 ** d - 1, 0, -1):
    tree[i] = tree[2 * i] + tree[2 * i + 1]

for i in range(m + k):
    a, b, c = map(int, read().split())
    if a == 1:
        b += 2 ** d - 1
        change = c - tree[b]
        while b > 0:
            tree[b] += change
            b //= 2
    else:
        start = b + 2 ** d - 1
        end = c + 2 ** d - 1
        answer = []
        while start <= end:
            if start % 2 == 1:
                answer.append(tree[start])
            if end % 2 == 0:
                answer.append(tree[end])
            start = (start + 1) // 2
            end = (end - 1) // 2
        print(sum(answer))