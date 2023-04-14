import sys
read = sys.stdin.readline

n = int(read())
A = list(map(int, read().split()))
L = [0] * n
R = [0] * n
D = [0] * n
L[0] = A[0]
R[-1] = A[-1]
D[0] = A[0]
answer = L[0]

for i in range(1, n):
    L[i] = max(L[i - 1] + A[i], A[i])
    answer = max(answer, L[i])

for i in range(n - 2, -1, -1):
    R[i] = max(R[i + 1] + A[i], A[i])

for i in range(1, n - 1):
    D[i] = L[i - 1] + R[i + 1]
    answer = max(answer, D[i])

print(answer)