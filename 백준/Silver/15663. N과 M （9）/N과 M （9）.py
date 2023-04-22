n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
visited = [False] * n
l = []

def dfs():
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    flag = 0
    for i in range(n):
        if not visited[i] and flag != num[i]:
            visited[i] = True
            l.append(num[i])
            flag = num[i]
            dfs()
            visited[i] = False
            l.pop()

dfs()