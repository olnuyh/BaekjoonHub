import heapq
import sys
read = sys.stdin.readline

n = int(read())
h = []
answer = ''

for i in range(n):
    m = int(read())
    if m != 0:
        heapq.heappush(h, (abs(m), m))
    else:
        if len(h) == 0:
            answer += '0\n'
        else:
            answer += str(heapq.heappop(h)[1]) + '\n'

print(answer)