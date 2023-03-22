import sys
read = sys.stdin.readline

def merge_sort(start, end):
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
        if tmp[index1] < tmp[index2]:
            l[k] = tmp[index1]
            k += 1
            index1 += 1
        else:
            l[k] = tmp[index2]
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
l = [0] * n
for i in range(n):
    l[i] = int(read())

tmp = [0] * n

merge_sort(0, n - 1)

for i in range(n):
    print(l[i], end = '\n')