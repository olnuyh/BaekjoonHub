import sys
read = sys.stdin.readline

n, startCity, endCity, m = map(int, read().split())
edges = []
for _ in range(m):
    start, end, price = map(int, read().split())
    edges.append((start, end, price))

cityMoney = list(map(int, read().split()))
distance = [-sys.maxsize] * n
distance[startCity] = cityMoney[startCity]

for i in range(n + 101):
    for start, end, price in edges:
        if distance[start] == -sys.maxsize:
            continue
        elif distance[start] == sys.maxsize:
            distance[end] = sys.maxsize
        elif distance[end] < distance[start] + cityMoney[end] - price:
            distance[end] = distance[start] + cityMoney[end] - price
            if i >= n - 1:
                distance[end] = sys.maxsize

if distance[endCity] == -sys.maxsize:
    print('gg')
elif distance[endCity] == sys.maxsize:
    print('Gee')
else:
    print(distance[endCity])