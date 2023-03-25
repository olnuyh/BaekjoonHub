expression = list(input().split('-'))
answer = 0

def plus(l):
    nums = list(l.split('+'))
    sum = 0
    for i in nums:
        sum += int(i)
    return sum

for i in range(len(expression)):
    num = plus(expression[i])
    if i == 0:
        answer += num
    else:
        answer -= num

print(answer)