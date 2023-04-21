a, b, c = map(int, input().split())
def mul_num(a, b, c):
    if b == 1:
        return a % c
    if b % 2 == 0:
        return (mul_num(a, b // 2, c) ** 2) % c
    return (mul_num(a, b // 2, c) ** 2)* a % c
print(mul_num(a, b, c))