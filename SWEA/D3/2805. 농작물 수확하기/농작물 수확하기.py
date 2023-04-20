T = int(input())
for test_case in range(1, T + 1):
    N = int(input())
    farm = []
    for _ in range(N):
        farm.append(list(map(int, input())))
    profit = 0
    s = N // 2
    e = N // 2
    for i in range(N):
        for j in range(s, e + 1):
            profit += farm[i][j]
        if i < N // 2:
            s -= 1
            e += 1
        else:
            s += 1
            e -= 1
    print(f'#{test_case} {profit}')