"""
문자와 숫자가 섞인 문자열을 입력 받고 문자열은 앞에 정렬 숫자는 맨뒤에 모두 더해서 출력하는 문제
"""

n = input()
result = []
value = 0

for i in n:
    if i.isalpha():
        result.append(i)
    else:
        value += int(i) # n을 문자열로 받았기 때문에 i도 문자이다. int형으로 변환해줘야 한다.

result.sort()

if value != 0: # 0일 경우에는 n에 숫자가 없었다는 것이기 때문에 추가해주면 안된다.
    result.append(value)

print(''.join(map(str, result)))
