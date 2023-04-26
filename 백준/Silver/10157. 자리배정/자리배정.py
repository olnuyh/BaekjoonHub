C, R = map(int, input().split())
K = int(input())

dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

Seat = [[0] * C for _ in range(R)]

if K > C * R:
    print(0)
else:
    nowR = R - 1
    nowC = 0
    d = 0
    num = 1
    while num <= K:
        if 0 <= nowR < R and 0 <= nowC < C and not Seat[nowR][nowC]:
            Seat[nowR][nowC] = num
            num += 1
        else:
            nowR -= dr[d]
            nowC -= dc[d]
            d = (d + 1) % 4
        nowR += dr[d]
        nowC += dc[d]
    print(nowC - dc[d] + 1, R - (nowR - dr[d]))