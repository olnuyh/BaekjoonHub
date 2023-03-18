check = 0 # 문자 개수 조건을 몇 개나 만족했는지 저장하는 변수
min_ch = [0] * 4 # 각 문자 별로 만족해야 하는 최소 개수를 저장하는 리스트
cur_state = [0] * 4 # 현재 문자가 각각 몇 개 존재하는지 저장하는 리스트

def add(ch):
    global check, min_ch, cur_state
    if ch == 'A':
        cur_state[0] += 1
        if cur_state[0] == min_ch[0]:
            check += 1
    elif ch == 'C':
        cur_state[1] += 1
        if cur_state[1] == min_ch[1]:
            check += 1
    elif ch == 'G':
        cur_state[2] += 1
        if cur_state[2] == min_ch[2]:
            check += 1
    elif ch == 'T':
        cur_state[3] += 1
        if cur_state[3] == min_ch[3]:
            check += 1

def remove(ch):
    global check, min_ch, cur_state
    if ch == 'A':
        if cur_state[0] == min_ch[0]:
            check -= 1
        cur_state[0] -= 1
    elif ch == 'C':
        if cur_state[1] == min_ch[1]:
            check -= 1
        cur_state[1] -= 1
    elif ch == 'G':
        if cur_state[2] == min_ch[2]:
            check -= 1
        cur_state[2] -= 1
    elif ch == 'T':
        if cur_state[3] == min_ch[3]:
            check -= 1
        cur_state[3] -= 1

s, p = map(int, input().split())
dna = list(input())
min_ch = list(map(int, input().split()))
count = 0

for i in range(4):
    if min_ch[i] == 0:
        check += 1

for i in range(p):
    add(dna[i])

if check == 4:
    count += 1

for i in range(p, s):
    add(dna[i])
    remove(dna[i - p])
    if check == 4:
        count += 1

print(count)