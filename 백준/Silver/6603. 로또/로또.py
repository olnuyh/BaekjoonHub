def dfs(n):
    if len(l) == 6:
        print(' '.join(map(str, l)))
        return
    for i in range(n, len(S)):
        if S[i] not in l:
            l.append(S[i])
            dfs(i + 1)
            l.pop()

while True:
    tmp = list(map(int, input().split()))
    if tmp[0] == 0:
        break
    S = tmp[1:]
    l = []
    dfs(0)
    print()