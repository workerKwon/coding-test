"""
자기 자신을 다시 호출하는 함수. 재귀함수

재귀 함수를 100번 호출하는 코드
"""

def recursive_function(i):
    if i == 100:
        return
    print(i, '번째 재귀함수에서', i+1, '번째 재귀 함수 호출')
    i += 1
    recursive_function(i)
    print(i, '번째 재귀함수 종료')

recursive_function(1)
