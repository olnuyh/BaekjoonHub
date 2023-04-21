n = int(input())
def func(s, e, c):
    if c == 1:
        print(s, e)
        return
    func(s, 6 - s - e, c - 1)
    print(s, e)
    func(6 - s - e, e, c - 1)

print((1 << n) - 1)
func(1, 3, n)