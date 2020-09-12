def binary_search(arr, start, end, target):
    while start <= end:
        mid = (start + end) // 2
        if arr[mid] == target:
            return mid
        elif arr[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return None

n, target = map(int, input().split())
arr = list(map(int, input().split()))

result = binary_search(arr, 0, n-1, target)
if result == None:
    print(target, "원소가 없습니다.")
else:
    print("arr의", result+1, "번째 원소")
