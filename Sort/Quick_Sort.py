"""
퀵 정렬은 기준을 설정한 다음 큰 수와 작은 수를 교환한 후 리스트를 반으로 나누는 방식으로 동작한다.
기준의 왼쪽에서 작은 수들을 놓고 오른쪽에는 큰수들을 놓는다.
그리고 기준을 제외한 오른쪽, 왼쪽 카드들을 다시 각각 기준을 잡고 기준의 왼쪽에 작은 수, 오른쪽에 큰수를 반복해서 두면서 정렬할 원소의 개수가 1개가 되면 끝낸다.
같은 코드를 반복하므로 재귀함수를 사용하는게 좋다.
"""

arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(arr, start_index, end_index):
    if start_index >= end_index: # 매번 재귀함수로 시작할때마다 원소의 시작 인덱스와 끝 인덱스를 검사한다.
        return # 시작 인덱스가 끝 인덱스보다 크거나 같으면 해당 재귀함수를 끝낸다.
                # 상위 재귀함수는 while문 반복을 끝냈으니 하위 재귀함수에서 아무것도 반환하지 않으면 상위 재귀함수는 while 반복을 끝으로 아무것도 하지 않는다(그냥 재귀함수의 동작이 끝난 것)
    pivot = start_index
    right = start_index + 1 # 오른쪽에 기준보다 큰 데이터의 인덱스
    left = end_index # 왼쪽에 기준보다 작은 데이터의 인덱스
    while right <= left:
        # 기준보다 큰 데이터를 찾을 때까지 오른쪽으로 인덱스를 1씩 늘린다.
        while right <= end_index and arr[right] <= arr[pivot]:
            right += 1
        # 기준보다 작은 데이터를 찾을 때까지 왼쪽으로 인덱스를 1씩 내려간다.
        while left > start_index and arr[left] >= arr[pivot]:
            left -= 1
        # 만약 기준보다 큰 데이터의 인덱스가 기준보다 작은 데이터의 인덱스보다 크다면 작은 데이터와 기준 데이터를 서로 교환해준다.
        if right > left:
            arr[left], arr[pivot] = arr[pivot], arr[left]
        else: # 찾은 큰 데이터의 인덱스가 작은 데이터의 인덱스보다 작다면 서로 위치를 바꿔준다.(큰 데이터를 높은 쪽으로 옮기는 것)
            arr[right], arr[left] = arr[left], arr[right]
        # 이것을 큰 데이터의 인덱스가 작은 데이터의 인덱스보다 커질 때까지(오른쪽에서 찾은 큰 데이터와 왼쪽에서 찾은 작은 데이터가 엇갈릴때까지) 반복한다.

    # 오른쪽의 큰 데이터와 왼쪽의 작은 데이터가 엇갈려서 반복이 끝났다면 기준이 가운데로 옮겨졌을 것이다.
    quick_sort(arr, start_index, left-1) # 정렬된 배열을 이용해서 0부터 바뀐 기준점이 된 left 인덱스의 -1까지
    quick_sort(arr, left+1, end_index) # 정렬된 배열을 이용해서 바뀐 기준점이 된 left 인덱스의 +1부터 마지막 배열까지 반복.

quick_sort(arr, 0, len(arr)-1)
print(arr)
