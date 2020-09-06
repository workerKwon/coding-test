"""
0~9의 숫자로 이루어진 문자열을 받고 그 문자열을 더하기 혹은 곱하기만 사용해서 나올 수 있는 가장 큰 수를 구한다.

풀이법.
결과와 연산하려는 수가 0 혹은 1일 때만 결과에 더하고 1보다 큰 수는 결과에 곱하면 가장 큰 수가 나온다.
"""
str = input()

result = 0

for i in range(len(str)):
    n = int(str[i])
    if n <= 1 or result <= 1:
        result += n
    else:
        result *= n

print(result)

