import sys
read = sys.stdin.readline

N = int(read())
A = list(map(int, read().split()))
A.insert(0, 0)

B = [0] * (N + 1)
D = [0] * (N + 1)
answer = [0] * (N + 1)

maxLength = 1
B[maxLength] = A[1]
D[1] = 1
index = 0

def binarysearch(left, right, value):
    while left < right:
        mid = (left + right) // 2
        if B[mid] < value:
            left = mid + 1
        else:
            right = mid
    return left

for i in range(2, N + 1):
    if B[maxLength] < A[i]:
        maxLength += 1
        B[maxLength] = A[i]
        D[i] = maxLength
    else:
        index = binarysearch(1, maxLength, A[i])
        B[index] = A[i]
        D[i] = index

print(maxLength)
index = maxLength

for i in range(N, 0, -1):
    if D[i] == index:
        answer[index] = A[i]
        index -= 1

for i in range(1, maxLength + 1):
    print(answer[i], end = ' ')