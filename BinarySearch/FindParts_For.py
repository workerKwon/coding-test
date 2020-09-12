import sys
r = sys.stdin.readline
n = int(r()) # 가지고 있는 부품의 종류 개수
parts = list(map(int, r().split())) # 가지고 있는 부품 종류의 각 번호
m = int(r()) # 찾으려는 부품 종류의 개수
finding_parts = list(map(int, r().split())) # 찾으려는 부품 종류의 각 번호

parts.sort() # 탐색을 위한 정렬
finding_parts.sort()

def binary_search(arr, start, end, target):
    while start <= end: # 탐색 시작 인덱스가 탐색 마지막 인덱스보다 커질때까지 반복
        mid = (start + end) // 2 # 가운데 인덱스를 찾는다.
        if arr[mid] == target: # 가운데 인덱스의 값과 target이 같으면 'yes'출력
            return 'yes'
        elif arr[mid] > target: # 가운데 인덱스의 값이 target보다 크다면 탐색 마지막 인덱스를 (가운데 인덱스-1)로 바꿔서 다시 탐색
            end = mid-1
        else:
            start = mid + 1 # 가운데 인덱스의 값이 target보다 작다면 탐색 시작 인덱스를 (가운데 인덱스+1)로 바꿔서 다시 탐색
    return 'no' # 탐색 시작 인덱스가 탐색 마지막 인덱스보다 커졌으면 target이 없는 것으로 'no' 출력

for i in finding_parts:
    print(binary_search(parts, 0, n-1, i), end=' ')
