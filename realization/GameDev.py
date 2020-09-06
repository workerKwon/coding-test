"""
현민이는 게임 캐릭터가 맵 안에서 움직이는 시스템을 개발 중이다.
캐릭터가 있는 장소는 1 * 1 크기의 정사각형으로 이뤄진 N * M 크기의 직사각형으로, 각각의 칸은 육지 또는 바다이다.
캐릭터는 동서남북 중 한 곳을 바라본다.
맵의 각 칸은 (A, B)로 나타낼 수 있고, A는 북쪽으로 떨어진 칸의 개수, B는 서쪽으로부터 떨어진 칸의 개수이다.
캐릭터는 상하좌우로 움직일 수 있고, 바다로 되어 있는 공간에는 갈 수 없다.
캐릭터의 움직임을 설정하기 위해 정해 놓은 매뉴얼은 이러하다.
1. 현재 위치에서 현재 방향을 기준으로 왼쪽 방향(반시계 방향으로 90도 회전한 방향)부터 차례대로 갈 곳을 정한다.
2. 캐릭터의 바로 왼쪽 방향에 아직 가보지 않은 칸이 존재한다면, 왼쪽 방향으로 회전한 다음 왼쪽으로 한 칸을 전진한다.
    왼쪽 방향에 가보지 않은 칸이 없다면, 왼쪽 방향으로 회전만 수행하고 1단계로 돌아간다.
3. 만약 네 방향 모두 이미 가본 칸이거나 바다로 되어 있는 칸인 경우에는, 바라보는 방향을 유지한 채로 한 칸 뒤로 가고 1단계로 돌아간다.
    단, 이때 뒤쪽 방향이 바다인 칸이라 뒤로 갈 수 없는 경우에는 움직임을 멈춘다.
현민이는 위 과정을 반복적으로 수행하면서 캐릭터의 움직임에 이상이 있는지 테스트하려고 한다.
매뉴얼에 따라 캐릭터를 이동시킨 뒤에, 캐릭터가 방문한 칸의 수를 출력하는 프로그램을 만드시오.

입력
첫째 줄에 맵의 세로 크기 N과 가로 크기 M을 공백으로 구분하여 입력한다.
둘째 줄에 게임 캐릭터가 있는 칸의 좌표(A, B)와 바라보는 방향 d가 각각 서로 공백으로 구분하여 주어진다. 방향 d의 값은 다음과 같다.
    0: 북쪽
    1: 동쪽
    2: 남쪽
    3: 서쪽
셋째 줄부터 맵이 육지인지 바다인지 입력한다. N개의 줄에 맵의 상태가 북쪽부터 남쪽 순서대로, 각 줄의 데이터는 서쪽부터 동쪽 순서대로 주어진다. 맵의 외곽은 항상 바다로 되어 있다.
    0: 육지
    1: 바다
처음에 게임 캐릭터가 위치한 칸의 상태는 항상 육지이다.
"""
n, m = map(int, input().split()) # 맵의 사이즈를 정의
A, B, direction = map(int, input().split()) # 캐릭터의 시작 위치와 바라보는 방향 정의

# 육지, 바다 결정
arr = []
for i in range(n):
    row_list = list(map(int, input().split()))
    arr.append(row_list)

d = [[0] * m for _ in range(n)] # 모든 맵을 방문하지 않은 상태로 초기화
d[A][B] = 1 # 캐릭터의 시작 위치만 방문한 것으로 변경.

# 북쪽(0)으로 이동할 경우 arr[A][] 를 위로 이동, 동쪽(1)로 이동할 경우 arr[][B] 를 오른쪽으로 이동.
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

# 방향 변경 함수
def turn_left():
    global direction
    direction -= 1
    if direction == -1:
        direction = 3   # 북쪽을 바라보고 있다면 서쪽으로 회전.

count = 1 # 시작 칸 방문 1 부터 시작.
turn_time = 0

while True:
    turn_left() # 회전
    nx = A + dx[direction] # 시작점이 1, 1이고 북쪽을 바라보고 시작했다면 회전했기 때문에 서쪽으로 이동할 준비를 한다. 캐릭터가 1, 0 위치로 이동이 가능한지 탐색한다.
    ny = B + dy[direction]
    # 정면에 방문하지 않은 육지가 있는지 체크.
    if d[nx][ny] == 0 and arr[nx][ny] == 0: # 1, 0이 방문한적이 없고, 육지라면 이동시키고, 다음 이동으로 넘어간다.
        d[nx][ny] = 1
        A = nx
        B = ny
        count += 1
        turn_time = 0
        continue
    else: # 아니라면 제자리에서 회전한 회수를 증가시킨다.
        turn_time += 1
    # 네 방향 모두 갈 수 없으면(제자리 회전 회수가 4라면)
    if turn_time == 4:
        nx = A - dx[direction] # 현재 바라보고 있는 방향에서 뒤로 이동 시킨 준비를 한다.
        ny = B - dy[direction]
        if arr[nx][ny] == 0: # 뒤쪽에 육지가 있을 경우 캐릭터를 이동
            A = nx
            B = ny
        else: # 네 방향을 다 탐색하고 뒤에 육지도 없으면 끝.
            break
        turn_time = 0

print(count)