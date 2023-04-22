n, m = map(int, input().split())
num = list(map(int, input().split()))
num.sort()
l = []

def dfs(start):
    if len(l) == m:
        print(' '.join(map(str, l)))
        return
    flag = 0
    for i in range(start, n):
        if flag != num[i]:
            l.append(num[i])
            flag = num[i]
            dfs(i)
            l.pop()

dfs(0)