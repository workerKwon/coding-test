import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class 미로탈출 {

    private static Integer N;
    private static Integer M;
    private static int[][] GRAPH;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstRow = br.readLine().split(" ");
        N = Integer.parseInt(firstRow[0]);
        M = Integer.parseInt(firstRow[1]);

        GRAPH = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = Integer.parseInt(st[j]);
            }
        }

        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] xy = queue.poll();
            int n = xy[0];
            int m = xy[1];

            for (int i = 0; i < 4; i++) {
                int nx = n + dx[i];
                int ny = m + dy[i];

                if (nx <= -1 || nx >= N || ny <= -1 || ny >= M) continue;
                if (GRAPH[nx][ny] == 0) continue;
                if (GRAPH[nx][ny] == 1) {
                    GRAPH[nx][ny] = GRAPH[n][m] + 1;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
        return GRAPH[N - 1][M - 1];
    }
}
