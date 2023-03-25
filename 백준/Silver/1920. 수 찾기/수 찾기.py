import sys
read = sys.stdin.readline

N = int(read())
L1 = list(map(int, read().split()))
L1.sort()
M = int(read())
L2 = list(map(int, read().split()))

for i in range(M):
    check = False
    find = L2[i]
    start = 0
    end = len(L1) - 1
    while start <= end:
        mid = (start + end) // 2
        if L1[mid] > find:
            end = mid - 1
        elif L1[mid] < find:
            start = mid + 1
        else:
            check = True
            break
    if check:
        print(1)
    else:
        print(0)