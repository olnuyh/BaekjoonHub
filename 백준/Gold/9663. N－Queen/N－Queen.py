N = int(input())

count = 0
check1 = [0] * (N + 1)
check2 = [0] * (2 * N)
check3 = [0] * (2 * N)

def dfs(r):
    global count
    if r == N:
        count += 1
        return
    for c in range(N):
        if check1[c] == check2[r + c] == check3[r - c + N - 1] == 0:
            check1[c] = check2[r + c] = check3[r - c + N - 1] = 1
            dfs(r + 1)
            check1[c] = check2[r + c] = check3[r - c + N - 1] = 0
dfs(0)
print(count)