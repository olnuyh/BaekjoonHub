from queue import PriorityQueue
N = int(input())
positive = PriorityQueue()
negative = PriorityQueue()
one = 0
zero = 0
sum = 0

for i in range(N):
    tmp = int(input())
    if tmp == 0:
        zero += 1
    elif tmp == 1:
        one += 1
    elif tmp <= -1:
        negative.put(tmp)
    else:
        positive.put((-tmp, tmp))

while positive.qsize() > 1:
    a = positive.get()[1]
    b = positive.get()[1]
    sum += a * b

if positive.qsize() == 1:
    sum += positive.get()[1]

while negative.qsize() > 1:
    a = negative.get()
    b = negative.get()
    sum += a * b

if negative.qsize() == 1:
    if zero > 0:
        sum += negative.get() * 0
    else:
        sum += negative.get()

sum += 1 * one

print(sum)