n = int(input())
count = n

for i in range(2, int(n ** 0.5) + 1):
    if n % i == 0:
        count = count - count // i
        while n % i == 0:
            n //= i

if n > 1:
    count = count - count // n

print(count)