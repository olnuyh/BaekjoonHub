min, max = map(int, input().split())
check = [1] * (max - min + 1)

for i in range(2, int(max ** 0.5) + 1):
    k = i * i
    s = 0 if min % k == 0 else k - (min % k) # s = (k - (min % k)) % k로도 표현 가능
    for j in range(s, len(check), k):
        check[j] = 0

print(sum(check))