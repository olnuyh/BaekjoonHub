from itertools import permutations
n, m = map(int, input().split())
nums = [i for i in range(1, n + 1)]
combi = permutations(nums, m)
for i in combi:
    for j in i:
        print(j, end = ' ')
    print()