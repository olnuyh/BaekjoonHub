import sys
sys.setrecursionlimit(10000)

A = list(input())
B = list(input())
D = [[0] * (len(B) + 1) for _ in range(len(A) + 1)]

for i in range(1, len(A) + 1):
    for j in range(1, len(B) + 1):
        if A[i - 1] == B[j - 1]:
            D[i][j] = D[i - 1][j - 1] + 1
        else:
            D[i][j] = max(D[i][j - 1], D[i - 1][j])

print(D[len(A)][len(B)])

answer = []
def getText(r, c):
    if r == 0 or c == 0:
        return
    if A[r - 1] == B[c - 1]:
        answer.append(A[r - 1])
        getText(r - 1, c -1)
    else:
        if D[r - 1][c] > D[r][c - 1]:
            getText(r - 1, c)
        else:
            getText(r, c - 1)

getText(len(A), len(B))

for i in range(len(answer) - 1, -1, -1):
    print(answer[i], end = '')