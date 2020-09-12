"""
부품 찾기
동빈이네 전자 매장에는 부품이 N개 있다. 각 부품은 정수 형태의 고유한 번호가 있다.
어느 날 손님이 M개 종류의 부품을 대량으로 구매하겠다며 당일 날 견적서를 요청했다. 동빈이는 때를 놓치지 않고 손님이 문의한
부품 M개 종류를 모두 확인해서 견적서를 작성해야 한다. 이때 가게 안에 부품이 모두 있는지 확인하는 프로그램을 작성해보자.
예를 들어 가게의 부품이 총 5개일 때 부품 번호가 다음과 같다고 하자.
n = 5
[8, 3, 7, 9, 2]
손님은 총 3개의 부품이 있는지 확인 요청했는데 부품 번호는 다음과 같다.
M = 3
[5, 7, 9]
이 때 손님이 요청한 부품 번호의 순서대로 부품을 확인해 부품이 있으면 yes를, 없으면 no를 출력한다. 구분은 공백으로 한다.

입력
첫째 줄에 정수 N이 주어진다.
둘째 줄에는 공백으로 구분하여 N개의 정수가 주어진다.
셋째 줄에는 정수 M이 주어진다.
넷째 줄에는 공백으로 구분하여 M개의 정수가 주어진다.

출력
첫째 줄에 공백으로 구분하여 각 부품이 존재하면 yes를, 없으면 no를 출력한다.
"""
import sys
r = sys.stdin.readline
n = int(r())
parts = list(map(int, r().split()))
m = int(r())
find_parts = list(map(int, r().split()))

parts.sort()
find_parts.sort()

def binary_search(parts, start, end, target):
    if start > end: # 탐색 시작 인덱스가 탐색 마지막 인덱스보다 크면 target이 없는 것으로 'no' 출력
        return 'no'
    mid = (start + end) // 2 # 가운데 인덱스 찾기
    if parts[mid] == target: # 가운데 인덱스의 값과 target이 같으면 'yes' 출력
        return 'yes'
    elif parts[mid] > target: # 가운데 인덱스의 값이 target보다 크다면 탐색 마지막 인덱스를 (가운데 인덱스-1)로 둔 재귀함수를 반환해서 범위가 절반으로 줄어든 탐색을 다시 시도.
        return binary_search(parts, start, mid-1, target)
    else: # 가운데 인덱스의 값이 target보다 작다면 탐색 시작 인덱스를 (가운데 인덱스+1)로 둔 재귀함수를 반환해서 범위가 절반으로 줄어든 탐색을 다시 하도록 함.
        return binary_search(parts, mid+1, end, target)

for i in find_parts:
    print(binary_search(parts, 0, n-1, i), end=' ')
