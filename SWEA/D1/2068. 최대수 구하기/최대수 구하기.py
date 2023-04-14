T = int(input())
for test_case in range(1, T + 1):
    answer = 0
    tmp = list(map(int, input().split()))
    for i in tmp:
        if answer < i:
            answer = i
    print(f'#{test_case} {answer}')
