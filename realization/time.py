"""
정수 N이 입력되면 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 구하는 프로그램.

입력
첫째 줄에 정수 N이 입력.

출력
00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 3이 하나라도 포함되는 모든 경우의 수를 출력.
"""

hour = int(input()) # 시각 입력
count = 0

for i in range(hour+1): # 입력한 시각까지
    for j in range(60): # 60분 반복
        for k in range(60): # 60초 반복
            t = str(i)+str(j)+str(k) # 문자열로 변환
            if '3' in t: # 변환된 문자열에 3이 포함되어 있으면 count 증가.
                count += 1
print(count)
