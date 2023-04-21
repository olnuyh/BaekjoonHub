n = int(input())
Fibo = [0] * (n + 1)
if n == 0:
    print(0)
else:
    Fibo[1] = 1
    for i in range(2, n + 1):
        Fibo[i] = Fibo[i - 2] + Fibo[i - 1]
    print(Fibo[n])