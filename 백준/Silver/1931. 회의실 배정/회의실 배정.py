N = int(input())
T = []
for i in range(N):
    s, e = list(map(int, input().split()))
    T.append((e,s))

T.sort()

count = 1
start = T[0][1]
end = T[0][0]

for i in range(1, N):
    if T[i][1] >= end:
        start = T[i][1]
        end = T[i][0]
        count += 1

print(count)