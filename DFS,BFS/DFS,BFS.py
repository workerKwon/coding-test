"""
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오.
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다.
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. V부터 방문된 점을 순서대로 출력하면 된다.
"""


# DFS 인접 행렬 방식으로 해결(간선이 연결하고 있는 노드를 입력했기 때문. 노드마다 인접한 노드를 입력하는 것으로 하면 인접 리스트 방식으로 해결)
n, m, v = map(int, input().split())
matrix = [[0 for _ in range(n+1)] for _ in range(n+1)] # 0노드가 아니라 1노드부터 시작하기 때문에 나중에 헷갈리지 않게 0노드를 추가하되 사용하지는 않는다.
for i in range(m): # 간선의 개수만큼 간선으로 연결되어 있는 노드 두개씩 입력
    a, b = map(int, input().split())
    matrix[a][b] = 1 # 인접 행렬 방식으로 인접한 두 노드는 1로 표현
    matrix[b][a] = 1

def dfs(graph, start, result):
    result.append(start) # 탐색 시작 노드를 결과에 추가.
    for i in range(1, n+1): # 노드가 1번부터이기 때문에 1부터 시작, n까지 포함.
        if graph[i][start] and i not in result: # 인접 행렬이 연결되어 있고(1이고), 결과에 탐색중인 노드가 없다면 추가.
            result = dfs(graph, i, result) # 재귀 함수를 사용해서 result를 리턴하므로 result를 탐색 중인 노드가 추가된 새로운 result로 변경.
    return result

print(' '.join(map(str, dfs(matrix, v, []))))
