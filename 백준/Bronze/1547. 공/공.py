M = int(input())
ball = 1
for _ in range(M):
    X, Y = map(int, input().split())
    if ball == X:
        ball = Y
    elif ball == Y:
        ball = X

print(ball)