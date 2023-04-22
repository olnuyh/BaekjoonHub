n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
l = []
def dfs(start):
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    for i in range(start, n):
        l.append(num[i])
        dfs(i + 1)
        l.pop()

dfs(0)