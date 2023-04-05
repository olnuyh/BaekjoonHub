from collections import deque
from queue import PriorityQueue
import sys
read = sys.stdin.readline
n, m = map(int, read().split())
myMap = []
for i in range(n):
    myMap.append(list(map(int, input().split())))

dr = [1, 0, -1, 0]
dc = [0, 1, 0, -1]
sumNum = 2
def BFS(a, b):
    queue = deque()
    queue.append((a, b))
    myMap[a][b] = sumNum
    while queue:
        r, c = queue.popleft()
        for i in range(4):
            nextR = r + dr[i]
            nextC = c + dc[i]
            if 0 <= nextR < n and 0 <= nextC < m and myMap[nextR][nextC] == 1:
                myMap[nextR][nextC] = sumNum
                queue.append((nextR, nextC))

for i in range(n):
    for j in range(m):
        if myMap[i][j] == 1:
            BFS(i, j)
            sumNum += 1

edges = PriorityQueue()
def findEdges(row, col):
    num = myMap[row][col]
    for i in range(4):
        nextR = row + dr[i]
        nextC = col + dc[i]
        l = 0
        while True:
            if 0 <= nextR < n and 0 <= nextC < m:
                if myMap[nextR][nextC] == num:
                    break
                elif myMap[nextR][nextC] > 1:
                    if l > 1:
                        edges.put((l, num, myMap[nextR][nextC]))
                    break
                else:
                    l += 1
                    nextR += dr[i]
                    nextC += dc[i]
            else:
                break


for i in range(n):
    for j in range(m):
        if myMap[i][j] > 1:
            findEdges(i, j)

def find(a):
    if a == parent[a]:
        return a
    else:
        parent[a] = find(parent[a])
        return parent[a]

def union(a, b):
    a = find(a)
    b = find(b)
    if a != b:
        parent[b] = a

parent = [i for i in range(sumNum)]

edge = 0
answer = 0

while edges.qsize() > 0:
    weight, start, end = edges.get()
    if find(start) != find(end):
        union(start, end)
        edge += 1
        answer += weight

if edge == sumNum - 3:
    print(answer)
else:
    print(-1)