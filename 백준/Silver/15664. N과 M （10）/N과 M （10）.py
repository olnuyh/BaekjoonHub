n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
l = []
visited = [False] * n

def dfs(start):
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    flag = 0
    for i in range(start, n):
        if not visited[i] and flag != num[i]:
            visited[i] = True
            l.append(num[i])
            flag = num[i]
            dfs(i + 1)
            visited[i] = False
            l.pop()

dfs(0)