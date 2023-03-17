n = int(input())
scores = list(map(int, input().split()))
m = max(scores)
print(sum(scores) / m * 100 /n)