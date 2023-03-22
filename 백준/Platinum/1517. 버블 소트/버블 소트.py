import sys
read = sys.stdin.readline

def merge_sort(start, end):
    global c
    if start == end:
        return
    mid = int(start + (end - start) / 2)
    merge_sort(start, mid)
    merge_sort(mid + 1, end)

    for i in range(start, end + 1):
        tmp[i] = l[i]

    k = start
    index1 = start
    index2 = mid + 1

    while index1 <= mid and index2 <= end:
        if tmp[index1] <= tmp[index2]:
            l[k] = tmp[index1]
            k += 1
            index1 += 1
        else:
            l[k] = tmp[index2]
            c += index2 - k
            k += 1
            index2 += 1

    while index1 <= mid:
        l[k] = tmp[index1]
        k += 1
        index1 += 1

    while index2 <= end:
        l[k] = tmp[index2]
        k += 1
        index2 += 1

n = int(read())
l = l = list(map(int, read().split()))

tmp = [0] * n

c = 0
merge_sort(0, n - 1)

print(c)