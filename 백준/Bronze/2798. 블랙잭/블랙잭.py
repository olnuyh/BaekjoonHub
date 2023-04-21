from itertools import combinations
N, M = map(int, input().split())
cards = list(map(int, input().split()))
combi_cards = list(combinations(cards, 3))
max = 0
for combi in combi_cards:
    if max < sum(combi) <= M:
        max = sum(combi)
print(max)