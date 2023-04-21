n = int(input())
Rectangles = [0] * (n + 2)
Rectangles[1] = 1
Rectangles[2] = 3
for i in range(3, n + 1):
    Rectangles[i] = (2 * Rectangles[i - 2] + Rectangles[i - 1]) % 10007
print(Rectangles[n])