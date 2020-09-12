import sys
r = sys.stdin.readline
n, m = map(int, r().split())
dduk_length = list(map(int, r().split()))

dduk_length.sort()
min_length = 0
def binary_search(arr, start, end, min_length):
    if start > end:
        return min_length
    mid = (start + end) // 2
    total = 0
    for i in arr:
        if i > mid:
            total += i - mid
    if total < m:
        return binary_search(arr, start, mid-1, min_length)
    else:
        min_length = mid
        return binary_search(arr, mid+1, end, min_length)



print(binary_search(dduk_length, 0, max(dduk_length), 0))
