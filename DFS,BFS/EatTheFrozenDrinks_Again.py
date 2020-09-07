n, m = map(int, input().split())
arr = []
for i in range(n):
    arr.append(list(map(int, input())))

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

def dfs(graph, x, y):
    graph[x][y] = 1
    for i in range(4):
        nx = x + dx[i]
        ny = y + dy[i]
        if nx >= 0 and nx < n and ny >= 0 and ny < m and graph[nx][ny] == 0:
            dfs(graph, nx, ny)

count = 0;
for i in range(n):
    for j in range(m):
        if arr[i][j] == 0:
            dfs(arr, i, j)
            count += 1

print(count)
