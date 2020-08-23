'''
다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙이다. 단 배열의 특정한 인덱스(번호)에 해당하는 수가
연속해서 K번 더해질 수 없다. 예를 들어 2, 4, 5, 4, 6으로 이루어진 배열이 있을 때 M이 8이고 K가 3이라고 가정하자.
이 경우 특정한 인덱스의 수가 연속해서 세 번까지만 더해질 수 있다. 큰 수의 법칙에 따르면 6+6+6+5+6+6+6+5 인 46이 된다.
단 서로 다른 인덱스에 해당하는 수가 같은 경우에도 서로 다른 것으로 간주한다.
예를 들어 3, 4, 3, 4, 3으로 이루어진 배열이 있을 때 M이 7이고, K가 2라고 가정하자. 이 경우 두번째 원소 4와 네번째 원소 4를 번갈아 두 번씩 더하는 것이 가능하다.
이 때 M이 8, K가 3이라고 하면 결과는 4+4+4+4+4+4+4+4인 28이 된다.
배열의 크기 n, 숫자가 더해지는 회수 m, 하나의 인덱스에 해당하는 수가 연속해서 더해질 수 있는 회수 k가 주어질 때 큰 수의 법칙에 따른 결과를 출력하시오.
'''

n, m, k = map(int, input().split()) # 공백으로 구분하여 숫자 입력
data = list(map(int, input().split())) # N개의 수를 공백으로 구분하여 입력받기

data.sort() # N개의 수 정렬
first = data[n-1] # data 리스트에서 가장 큰 수
second = data[n-2] # data 리스트에서 두번째로 큰 수

result = 0 # 결과 초기화

while True: # 연산 회수 m이 0이 될 때 까지 반복
    for i in range(k): # 가장 큰 수는 최대 k번 반복해서 더할 수 있다.
        if m == 0: # 연산 회수가 0번 남았다면 반복문 탈출
            break
        result += first # 가장 큰 수 더하기
        m -= 1 # 더하고 난 후 연산 회수 m에서 -1
    if m == 0: # 가장 큰 수를 연속해서 k번 더하고 연산 회수가 0이라면 반복문 탈출
        break
    result += second # 가장 큰 수를 연속해서 최대 k번 더하고 그 다음 큰 수를 한번 연산해야 한다.
    m -= 1 # 연산 후 연산 가능 회수 m을 -1. m이 0이 아니라면 다시 반복.

print(result) # 반복문이 끝난 연산 결과 출력
