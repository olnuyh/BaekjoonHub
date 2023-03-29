n = int(input())
def gcd(a, b):
    global result
    m = max(a, b)
    n = min(a, b)
    k = m % n

    if k != 0:
        gcd(n, k)
    else:
        result = n

for i in range(n):
    a, b = map(int, input().split())
    result = 0
    gcd(a, b)
    print(a * b // result)