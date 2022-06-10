/**
 * 1. 탐색 시작 노드를 스택에 삽입하고 방문처리
 * 2. 스택의 최상단 노드에 방문하지 않은 인접노드가 있다면 그 인접 노드를 스택에 넣고 방문처리.
 *      방문하지 않은 인접 노드가 없다면 스택에서 최상단 노드를 꺼낸다
 * 3. 2번 과정을 수행할 수 없을 때까지 반복한다.
 */

public class DFS {
    public static void main(String[] args) {
        int[][] graph = {
                {},
                {2, 3, 8},
                {1, 7},
                {1, 4, 5},
                {3, 5},
                {3, 4},
                {7},
                {2, 6, 8},
                {1, 7}
        };

        boolean[] visited = new boolean[9];

        dfs(graph, 1, visited);
    }

    private static void dfs(int[][] graph, int v, boolean[] visited) {
        // 시작노드 방문 처리
        visited[v] = true;
        System.out.println(v);
//        for (int i = 0; i < graph[v].length; i++) {
//            if (!visited[graph[v][i]]) dfs(graph, graph[v][i], visited);
//        }

        // 시작노드에 인접해 있는 노드들 중 방문하지 않은 노드가 있다면 재귀적으로 탐색
        for (int i : graph[v]) {
            if(!visited[i]) dfs(graph, i, visited);
        }
    }
}
