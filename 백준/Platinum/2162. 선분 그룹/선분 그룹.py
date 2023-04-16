N = int(input())
parent = [-1] * (N + 1)

def CCW(x1, y1, x2, y2, x3, y3):
    c = (x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)
    if c == 0:
        return 0
    elif c > 0:
        return 1
    else:
        return -1

def isOverlap(x1, y1, x2, y2, x3, y3, x4, y4):
    if min(x1, x2) <= max(x3, x4) and min(x3, x4) <= max(x1, x2) and min(y1, y2) <= max(y3, y4) and min(y3, y4) <= max(y1, y2):
        return True
    return False

def isCross(x1, y1, x2, y2, x3, y3, x4, y4):
    abc = CCW(x1, y1, x2, y2, x3, y3)
    abd = CCW(x1, y1, x2, y2, x4, y4)
    cda = CCW(x3, y3, x4, y4, x1, y1)
    cdb = CCW(x3, y3, x4, y4, x2, y2)
    if abc * abd == 0 and cda * cdb == 0:
        return isOverlap(x1, y1, x2, y2, x3, y3, x4, y4)
    elif abc * abd <= 0 and cda * cdb <= 0:
        return True
    return False

def find(a):
    if parent[a] < 0:
        return a
    parent[a] = find(parent[a])
    return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a == b:
        return
    parent[a] += parent[b]
    parent[b] = a

Line = []
Line.append([])

for i in range(1, N + 1):
    Line.append(list(map(int, input().split())))
    for j in range(1, i):
        if isCross(Line[i][0], Line[i][1], Line[i][2], Line[i][3], Line[j][0], Line[j][1], Line[j][2], Line[j][3]):
            union(i, j)

count = 0
answer = 0

for i in range(1, N + 1):
    if parent[i] < 0:
        count += 1
        answer = min(answer, parent[i])

print(count)
print(-answer)