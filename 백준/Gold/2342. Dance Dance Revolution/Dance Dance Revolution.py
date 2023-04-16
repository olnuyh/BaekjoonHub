import sys
read = sys.stdin.readline
move = list(map(int, read().split()))
strength = [[0, 2, 2, 2, 2], [2, 1, 3, 4, 3], [2, 3, 1, 3, 4], [2, 4, 3, 1, 3], [2, 3, 4, 3, 1]]

D = [[[sys.maxsize] * 5 for _ in range(5)] for _ in range(len(move) + 1)]
D[0][0][0] = 0
s = 1
index = 0
while move[index] != 0:
    to = move[index]
    for i in range(5):
        if to == i: 
            continue
        for j in range(5):
            D[s][i][to] = min(D[s][i][to], D[s - 1][i][j] + strength[j][to])
    for j in range(5): 
        if to == j:
            continue
        for i in range(5):
            D[s][to][j] = min(D[s][to][j], D[s - 1][i][j] + strength[i][to])
    s += 1
    index += 1

s -= 1
answer = sys.maxsize
for i in range(5):
    for j in range(5):
        answer = min(answer, D[s][i][j])

print(answer)