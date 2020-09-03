"""
신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

어느 날 1번 컴퓨터가 웜 바이러스에 걸렸다.
컴퓨터의 수와 네트워크 상에서 서로 연결되어 있는 정보가 주어질 때,
1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

입력
첫째 줄에는 컴퓨터의 수가 주어진다. 컴퓨터의 수는 100 이하이고 각 컴퓨터에는 1번 부터 차례대로 번호가 매겨진다.
둘째 줄에는 네트워크 상에서 직접 연결되어 있는 컴퓨터 쌍의 수가 주어진다.
이어서 그 수만큼 한 줄에 한 쌍씩 네트워크 상에서 직접 연결되어 있는 컴퓨터의 번호 쌍이 주어진다.

출력
1번 컴퓨터가 웜 바이러스에 걸렸을 때, 1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 첫째 줄에 출력한다.
"""

n = int(input())
m = int(input()) # 둘째줄. 연결되어 있는 컴퓨터 쌍의 수(간선의 수)
matrix = [[0 for _ in range(n+1)] for _ in range(n+1)] # 1번 노드부터 시작이니까 0번째 노드는 추가하되 사용하지는 않는다.
for i in range(m):
    a, b = map(int, input().split())
    matrix[a][b] = 1
    matrix[b][a] = 1

# dfs 방식으로 해결
def dfs(graph, v, result):
    result.append(v) # 방문 지역 체크
    for i in range(1, n+1): # 1번 노드부터 시작
        if graph[v][i] and i not in result: # 탐색 중인 노드와 인접한 노드이면서 방문하지 않은 노드
            result = dfs(graph, i, result) # 재귀함수를 통해 result에 추가하고 return받은 노드가 추가된 result로 변경.
    return result

# bfs 방식으로 해결
def bfs(graph, v, result):
    queue = [v] # 큐에 쌓는다.
    result.append(v) # 큐에 들어간 순서대로 결과를 출력한다.
    while queue: # 큐에 요소가 있는 동안 계속 반복
        k = queue.pop(0) # 큐의 최하단 요소를 뽑아서 탐색.
        for i in range(1, n+1): # 1번 컴퓨터부터 마지막 컴퓨터까지 반복
            if graph[k][i] and i not in result: # 탐색 중인 컴퓨터와 인접한 컴퓨터이면서 아직 탐색하지 않은 컴퓨터는 큐에 쌓는다.
                queue.append(i)
                result.append(i)
    return result

print(len(dfs(matrix, 1, []))-1) # 1번 컴퓨터로부터 감염된 컴퓨터의 개수 탐색
print(len(bfs(matrix, 1, []))-1) # 1번 컴퓨터로부터 감염된 컴퓨터의 개수 탐색

