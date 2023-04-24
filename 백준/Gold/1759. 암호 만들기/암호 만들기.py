L, C = map(int, input().split())
alphabets = list(input().split())
alphabets.sort()

def dfs(start, l):
    if len(l) == L:
        count = 0
        for i in l:
            if i in ['a', 'e', 'i', 'o', 'u']:
                count += 1
        if count >= 1 and L - count >= 2:
            print(''.join(l))
    for i in range(start, C):
        if alphabets[i] not in l:
            l.append(alphabets[i])
            dfs(i + 1, l)
            l.pop()

dfs(0, [])