n = int(input())
x, y = 1, 1
str = input().split()

dx = [-1, 0, 1, 0]
dy = [0, 1, 0, -1]

dir = ['U', 'R', 'D', 'L']

for i in str:
    for j in range(len(dir)):
        if i == dir[j]:
            nx = x + dx[j]
            ny = y + dy[j]
    if nx >= 1 and nx <= n and ny >= 1 and ny <= n:
        x = nx
        y = ny

print(x, y)
