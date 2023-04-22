L = int(input())
N = int(input())
cake = [0] * (L + 1)
want = [0] * (N + 1)
real = [0] * (N + 1)
for i in range(N):
    P, K = map(int, input().split())
    want[i + 1] = K - P + 1
    for j in range(P, K + 1):
        if cake[j] == 0:
            cake[j] = i + 1
for i in range(L):
    if cake[i] != 0:
        real[cake[i]] += 1

print(want.index(max(want)))
print(real.index(max(real)))