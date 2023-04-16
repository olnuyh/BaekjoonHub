N = int(input())
Point = []
Point.append([])

for _ in range(N):
    x, y = map(int, input().split())
    Point.append((x, y))

def CCW(x1, y1, x2, y2, x3, y3):
    return ((x1 * y2 + x2 * y3 + x3 * y1) - (x2 * y1 + x3 * y2 + x1 * y3)) / 2

answer = 0
for i in range(2, N):
    answer += CCW(Point[1][0], Point[1][1], Point[i][0], Point[i][1], Point[i + 1][0], Point[i + 1][1])

print(abs(answer))