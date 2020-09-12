import sys
r = sys.stdin.readline

n = int(r())
n_arr = list(map(int, r().split()))
m = int(r())
m_arr = list(map(int, r().split()))

n_arr.sort()

def binary_search(arr, start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return 1
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 0

for i in m_arr:
    print(binary_search(n_arr, 0, n-1, i))
