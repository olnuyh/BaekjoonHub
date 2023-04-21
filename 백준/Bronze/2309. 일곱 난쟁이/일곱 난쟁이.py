from itertools import combinations
Height = []
for i in range(9):
    Height.append(int(input()))
combi = list(combinations(Height, 7))
seven_dwarf = []
for c in combi:
    if sum(c) == 100:
        seven_dwarf.append(c)
answer = sorted(list(seven_dwarf[0]))
for h in answer:
    print(h)