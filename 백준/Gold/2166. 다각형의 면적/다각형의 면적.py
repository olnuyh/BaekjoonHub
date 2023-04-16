N = int(input())
X = []
Y = []

for _ in range(N):
    x1, y1 = map(int, input().split())
    X.append(x1)
    Y.append(y1)

X.append(X[0])
Y.append(Y[0])

def CCW(x1, y1, x2, y2):
    return x1 * y2 - x2 * y1

answer = 0
for i in range(N):
    answer += (X[i] * Y[i + 1] - X[i + 1] * Y[i])

print(round(abs(answer / 2), 1))