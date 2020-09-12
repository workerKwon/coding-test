import sys
r = sys.stdin.readline
n = int(r())
parts = list(map(int, r().split()))
m = int(r())
finding_parts = list(map(int, r().split()))

parts.sort()
finding_parts.sort()

def binary_search(arr, start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return 'yes'
        elif arr[mid] > target:
            end = mid-1
        else:
            start = mid + 1
    return 'no'

for i in finding_parts:
    print(binary_search(parts, 0, n-1, i), end=' ')
