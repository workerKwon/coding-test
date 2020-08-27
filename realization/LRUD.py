"""
여행가 A는 N * N 크기의 정사각형 공간 위에 서 있다. 이 공간은 1 * 1 크기의 정사각형으로 나누어져 있다.
가장 왼쪽 위 좌표는 (1, 1)이며, 가장 오른쪽 아래 좌표는 (N, N)에 해당한다.
여행가 A는 상, 하, 좌, 우 방향으로 이동할 수 있으며, 시작 좌표는 항상 (1, 1)이다.
우리 앞에는 여행가 A가 이동할 계획이 적힌 계획서가 놓여있다.

L : 왼쪽으로 한 칸 이동
R : 오른쪽으로 한 칸 이동
U : 위로 한 칸 이동
D : 아래로 한 칸 이동

이때 여행가 A가 N * N 크기의 정사각형 공간을 벗어나는 움직임은 무시된다.

입력
첫째 줄에 공간의 크기를 나타내는 N이 주어진다.(1 <= N <= 100)
둘째 줄에 여행가 A가 이동할 계획서 내용이 주어진다.

출력
첫째 줄에 여행가 A가 최종적으로 도착할 지점의 좌표 (X, Y)를 공백으로 구분하여 출력한다.
"""
import time
n = int(input())
move = list(input().split())
result = [1, 1]
start = time.time()
for i in range(len(move)):
    if move[i] == 'L' and result[1] - 1 > 1:
        result[1] -= 1
    elif move[i] == 'R' and result[1] + 1 < n:
        result[1] += 1
    elif move[i] == 'U' and result[0] - 1 > 1:
        result[0] -= 1
    elif move[i] == 'D' and result[0] + 1 < n:
        result[0] += 1
print(*result)

print(time.time() - start)

################################################################################################

# 정석 풀이. 내가 한 방법보다 문제 풀이의 구분이 명확하다.
n = int(input())
x, y = 1, 1
plans = input().split()

dx = [0, 0, -1, 1]
dy = [-1, 1, 0, 0]
start = time.time()
move_types = ['L', 'R', 'U', 'D']

for plan in plans:
    for i in range(len(move_types)):
        if plan == move_types[i]:
            nx = x + dx[i]
            ny = y + dy[i]

    if nx < 1 or ny < 1 or nx > n or ny > n:
        continue # nx, ny가 범위를 벗어나는 경우 x, y에 대입하지 않고 넘어간다.

    x, y = nx, ny

print(x, y)
print(time.time() - start)
