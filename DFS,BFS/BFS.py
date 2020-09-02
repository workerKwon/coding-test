"""
BFS는 너비 우선 탐색이라고 한다. 가장 가까운 노드부터 탐색하는 알고리즘이다.
BFS 구현에서는 선입선출 방식인 큐 자료구조를 이용하는 것이 정석이다. 인접한 노드를 반복적으로 큐에 넣도록 알고리즘을 작성하면 자연스럽게 먼저 들어온 것이 나가게 되어,
가까운 노드부터 탐색을 진행하게 된다.
1. 탐색 시작 노드를 큐에 삽입하고 방문 처리 한다.
2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문처리한다.
3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
"""

from collections import deque

# 재귀 함수를 사용하지 않음.
def bfs_function(graph, start, visited):
    queue = deque([start]) # queue에 시작 노드를 넣는다.
    while queue:
        v = queue.popleft() # 먼저 들어간 노드를 뽑는다.
        visited[v] = True # 먼저 queue에 들어간 노드를 방문 처리한다.
        print(v, end=' ') # 방문 처리된 노드 출력
        for i in graph[v]: # 인접한 노드들 전부 수행
            if not visited[i]: # 인접한 노드 중에 방문하지 않은 노드가 있는지 체크
                queue.append(i) # 방문하지 않은 노드를 queue 최상위에 추가.
                visited[i] = True # queue에 들어간 노드는 방문 처리.

graph = [
    [],
    [2, 3, 8],
    [1, 7],
    [1, 4, 5],
    [3, 5],
    [3, 4],
    [7],
    [2, 6, 8],
    [1, 7]
]

visited = [False] * 9

bfs_function(graph, 1, visited)
