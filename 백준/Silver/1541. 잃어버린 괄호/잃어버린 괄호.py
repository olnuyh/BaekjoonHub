s = input()

num = ''
minus = 0
answer = 0

for i in range(len(s)):
    if s[i] == '-':
        if minus == 0:
            answer += int(num)
        else:
            answer -= int(num)
        num = ''
        minus += 1
    elif s[i] == '+':
        if minus == 0:
            answer += int(num)
        else:
            answer -= int(num)
        num = ''
    else:
        num += s[i]

if minus != 0:
    answer -= int(num)
else:
    answer += int(num)
print(answer)