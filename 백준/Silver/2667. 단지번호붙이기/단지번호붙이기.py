n = int(input())
myMap = [[] for _ in range(n)]
for i in range(n):
    myMap[i] = list(map(int, input()))

dr = [1, -1, 0, 0]
dc = [0, 0, 1, -1]

def DFS(now_r, now_c):
    global house
    if now_r < 0 or now_r >= n or now_c < 0 or now_c >= n:
        return False
    if myMap[now_r][now_c] == 1:
        myMap[now_r][now_c] = 0
        house += 1
        for i in range(4):
            next_r = now_r + dr[i]
            next_c = now_c + dc[i]
            DFS(next_r, next_c)
        return True
    return False

house = 0
complex = 0
count = []

for i in range(n):
    for j in range(n):
        if DFS(i, j):
            count.append(house)
            complex += 1
            house = 0

print(complex)
count.sort()
for i in count:
    print(i)