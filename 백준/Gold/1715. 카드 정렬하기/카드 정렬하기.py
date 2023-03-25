from queue import PriorityQueue
N = int(input())
q = PriorityQueue()

for i in range(N):
    q.put(int(input()))

sum = 0
while q.qsize() > 1:
    a = q.get()
    b = q.get()
    sum += a + b
    q.put(a + b)

print(sum)