import sys
read = sys.stdin.readline

n = int(read())
distance = []
answer = [[0] * n for _ in range(n)]
for i in range(n):
    distance.append(list(map(int, read().split())))

for k in range(n):
    for start in range(n):
        for end in range(n):
            if distance[start][k] == 1 and distance[k][end] == 1:
                distance[start][end] = 1

for i in range(n):
    for j in range(n):
        print(distance[i][j], end = ' ')
    print()