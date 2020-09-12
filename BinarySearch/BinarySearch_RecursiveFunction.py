"""
이진 탐색은 배열 내부의 데이터가 정렬되어 있어야만 사용할 수 있는 알고리즘이다.
이진 탐색은 탐색 범위를 절반씩 좁혀가며 데이터를 탐색하는 특징이 있다.
이진 탐색은 위치를 나타내는 변수 3개를 사용하는데 탐색하고자 하는 범위의 시작점, 끝점, 중간점이 필요하다.
찾으려는 데이터와 중간점 위치에 있는 데이터를 반복적으로 비교해서 원하는 데이터를 찾는게 이진 탐색 과정이다.
"""

def binary_search(arr, start, end, target):
    if start > end:
        return None
    mid = (start + end) // 2
    if arr[mid] == target:
        return mid
    elif arr[mid] > target:
        return binary_search(arr, start, mid - 1, target)
    else:
        return binary_search(arr, mid + 1, end, target)

n, target = map(int, input().split())
array = list(map(int, input().split()))

result = binary_search(array, 0, n - 1, target)
if result == None:
    print("target 원소가 존재하지 않습니다.")
else:
    print(result + 1,"번째 수")
    print("arr[", result, "]")
