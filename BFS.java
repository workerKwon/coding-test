import java.util.LinkedList;
import java.util.Queue;

/**
 * 1. 탐색 시작 노드를 큐에 삽입하고 방문 처리를 한다.
 * 2. 큐에서 노드를 꺼내 해당 노드의 인접 노드 중에서 방문하지 않은 노드를 모두 큐에 삽입하고 방문 처리를 한다.
 * 3. 2번의 과정을 더 이상 수행할 수 없을 때까지 반복한다.
 */
public class BFS {
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

        bfs(graph, 1, visited);
    }

    private static void bfs(int[][] graph, int v, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();

        // 시작 노드를 queue에 넣고 방문처리
        queue.add(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            // 큐의 맨앞에 있는 노드를 꺼내옴.
            v = queue.poll();
            System.out.println(v);

            // 큐의 맨 앞 노드와 인접한 노드 중에 방문하지 않은 노드들을 모두 큐에 넣고 방문처리함.
            for (int i : graph[v]) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
