import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 미로탈출 {

    static int N;
    static int M;
    static int[][] GRAPH;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        GRAPH = new int[N][M];

        for(int i = 0; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                GRAPH[i][j] = row.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0 ,0});
        while (q.size() > 0) {
            int[] xy = q.poll();
            int x = xy[0];
            int y = xy[1];
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M || GRAPH[nx][ny] == 0) continue;
                if(GRAPH[nx][ny] == 1) {
                    GRAPH[nx][ny] = GRAPH[x][y] + 1;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        System.out.println(GRAPH[N-1][M-1]);
    }
}
