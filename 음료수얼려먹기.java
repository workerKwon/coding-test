import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 음료수얼려먹기 {
    static Integer N;
    static Integer M;

    static int[][] GRAPH;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstRow = br.readLine().split(" ");
        N = Integer.parseInt(firstRow[0]);
        M = Integer.parseInt(firstRow[1]);

        GRAPH = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                GRAPH[i][j] = Integer.parseInt(st[j]);
            }
        }

        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (dfs(i, j)) count++;
            }
        }

        System.out.println(count);
    }

    static boolean dfs(int x, int y) {
        if (x <= -1 || x >= N || y <= -1 || y >= M) {
            return false;
        }

        if (GRAPH[x][y] == 0) {
            GRAPH[x][y] = 1;
            dfs(x - 1, y);
            dfs(x + 1, y);
            dfs(x, y - 1);
            dfs(x, y + 1);
            return true;
        }

        return false;
    }
}
