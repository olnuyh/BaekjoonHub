import sys
sys.setrecursionlimit(10**6)
read = sys.stdin.readline
n = int(read())
l = [[] for _ in range(n)]
parents = list(map(int, read().split()))
delNode = int(read())
answer = 0

for i in range(n):
    if parents[i] == -1:
        root = i
    else:
        l[i].append(parents[i])
        l[parents[i]].append(i)

visited = [False] * n

def DFS(node):
    global answer
    count = 0
    visited[node] = True
    for i in l[node]:
        if not visited[i] and i != delNode:
            count += 1
            DFS(i)
    if count == 0:
        answer += 1

if root == delNode:
    print(0)
else:
    DFS(root)
    print(answer)