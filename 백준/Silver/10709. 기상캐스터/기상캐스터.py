H, W = map(int, input().split())
JOI = []
for _ in range(H):
    sky = list(input())
    tmp = []
    for i in sky:
        if i == 'c':
            tmp.append(0)
        else:
            tmp.append(-1)
    JOI.append(tmp)

for i in range(H):
    cloud = False
    minute = 0
    for j in range(W):
        if JOI[i][j] == 0:
            cloud = True
            minute = 1
            continue
        if cloud:
            JOI[i][j] = minute
            minute += 1

for i in range(H):
    for j in range(W):
        print(JOI[i][j], end = ' ')
    print()