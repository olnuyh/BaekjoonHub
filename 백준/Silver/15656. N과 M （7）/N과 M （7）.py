n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
l = []

def dfs():
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    for i in range(n):
        l.append(num[i])
        dfs()
        l.pop()

dfs()