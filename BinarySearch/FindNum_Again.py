import sys
input = sys.stdin.readline
n, n_arr, m, m_arr = int(input()), set(map(int, input().split())), int(input()), list(map(int, input().split()))

for i in m_arr:
    if i in n_arr:
        print(1)
    else:
        print(0)
