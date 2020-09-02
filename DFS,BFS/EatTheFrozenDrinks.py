"""
N * M 크기의 얼음 틀이 있다. 구멍이 뚫려 있는 부분은 0, 칸막이가 존재하는 부분은 1로 표시된다.
구멍이 뚫려 있는 부분끼리 상, 하, 좌, 우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
이때 얼음 틀의 모양이 주어졌을 때 생성되는 총 아이스크림의 개수를 구하는 프로그램을 작성하시오.
다음의 4 * 5 얼음 틀 예시에서는 아이스크림이 총 3개 생성된다.
00110
00011
11111
00000

입력
첫 번째 출에 얼음 틀의 세로 길이 N과 가로 길이 M이 주어진다.
두 번째 줄부터 N+1번째 줄까지 얼음 틀의 형태가 주어진다.
이때 구멍이 뚫려있는 부분은, 그렇지 않은 부분은 1이다.

출력
한 번에 만들 수 있는 아이스크림의 개수를 출력한다.
"""

n, m = map(int, input().split())

graph = []
for i in range(n):
    graph.append(list(map(int, input()))) # 얼음 판 정보 받기 2차원 배열

def dfs(x, y):
    if x < 0 or x > n-1 or y < 0 or y > m-1: # 범위를 벗어나면 바로 False
        return False
    if graph[x][y] == 0: # 얼음판이 구멍이 나있으면
        graph[x][y] = 1 # 구멍나 있는 부분은 방문한 것으로 변경
        dfs(x-1, y) # 주변 노드들 재귀적으로 호출
        dfs(x+1, y)
        dfs(x, y-1)
        dfs(x, y+1)
        return True
    return False

result = 0
for i in range(n):
    for j in range(m):
        if dfs(i, j) == True: #dfs를 수행하면 시작 노드의 주변 노드들이 방문한 것으로 변경되기 때문에 graph[i][j]번째의 결과만 True이면 인접한 노드들 모두 탐색한 것이다.
            result += 1

print(result)
