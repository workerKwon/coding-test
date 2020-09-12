import sys
r = sys.stdin.readline

n = int(r())
parts = list(map(int, r().split()))
m = int(r())
finding_parts = list(map(int, r().split()))

max_num = max(parts)

arr = [0] * (max_num + 1)

for i in finding_parts:
    for j in parts:
        if i == j:
            arr[i] += 1
            break

for i in finding_parts:
    if arr[i] != 0:
        print('yes', end=' ')
    else:
        print('no', end=' ')
