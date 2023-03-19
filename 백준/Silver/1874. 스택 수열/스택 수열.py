import sys
read = sys.stdin.readline

n = int(read())
l = [0] * n

for i in range(n):
    l[i] = int(read())

num = 1
s = []
answer = ''
result = True

for i in range(n):
    if l[i] >= num:
        while l[i] >= num:
            s.append(num)
            num += 1
            answer += '+\n'
        s.pop()
        answer += '-\n'
    else:
        p = s.pop()
        if p > l[i]:
            print('NO')
            result = False
            break
        else:
            answer += '-\n'

if result:
    print(answer)

