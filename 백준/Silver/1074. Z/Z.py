N, r, c = map(int, input().split())
def func(N, r, c):
    if N == 0:
        return 0
    half = 2 ** (N - 1)
    if r < half and c < half:
        return func(N - 1, r, c)
    elif r < half and c >= half:
        return func(N - 1, r, c - half) + half * half
    elif r >= half and c < half:
        return func(N - 1, r - half, c) + 2 * half * half
    else:
        return func(N - 1, r - half, c - half) + 3 * half * half

print(func(N, r, c))