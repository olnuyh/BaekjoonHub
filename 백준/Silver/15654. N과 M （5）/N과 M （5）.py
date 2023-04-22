n, m = map(int, input().split())
num = list(map(int, input().split()))
l = []
def dfs():
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    for i in range(len(num)):
        if num[i] not in l:
            l.append(num[i])
            dfs()
            l.pop()

num.sort()
dfs()