n, m = map(int,input().split())
arr = []
for i in range(n):
    arr.append(list(map(int, input())))

# 상, 우, 하, 좌 방향 설정
dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def bfs(x, y): # 시작 노드부터 마지막 노드까지 인접한 노드부터 탐색하는 문제이기 때문에 bfs 알고리즘을 사용
    queue = []
    queue.append((x, y)) # 시작 좌표를 큐에 넣는다.
    while queue:
        x, y = queue.pop(0) # 큐의 최하단 원소(위치)를 뽑아온다.
        for i in range(4): # 반복문을 돌려 상하좌우 네방향을 탐색한다.
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < n and ny >= 0 and ny < m and arr[nx][ny] == 1: # 이동 가능한 인접한 노드가 있으면
                arr[nx][ny] = arr[x][y] + 1 # 조건이 만족한다면 다음 노드의 값을 이전 노드의 값에 1을 더한 값으로 바꿔준다. 노드의 값이 1일 경우에만 탐색하므로 노드의 값이 계속 늘어가면 되돌아와서 탐색하지 않는다.
                queue.append((nx, ny))
    return arr[n-1][m-1] # 마지막 노드의 값이 최단 경로의 이동횟수가 된다.

print(bfs(0,0))
