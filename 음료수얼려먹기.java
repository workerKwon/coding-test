import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * N * M 크기의 얼음 틀이 있다. 구멍이 뚫린 부분은 0, 칸막이가 존재하는 부분은 1
 * 구멍이 뚫린 부분끼리 상,하,좌,우로 붙어 있는 경우 서로 연결되어 있는 것으로 간주한다.
 * 이 때 만들 수 있는 얼음의 개수를 구하는 프로그램 작성
 */
public class 음료수얼려먹기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        for(int i = 0 ; i < N; i++) {
            String row = br.readLine();
            for(int j = 0; j < M; j++) {
                A[i][j] = row.charAt(j) - '0';
            }
        }

        int cnt = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(dfs(i, j, A, N, M) == true) cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean dfs(int x, int y, int[][] A, int xMax, int yMax) {
        if(x <= -1 || x >= xMax || y <= -1 || y >= yMax) return false;
        if(A[x][y] == 0) {
            A[x][y] = 1;
            dfs(x-1, y, A, xMax, yMax);
            dfs(x, y-1, A, xMax, yMax);
            dfs(x+1, y, A, xMax, yMax);
            dfs(x, y+1, A, xMax, yMax);
            return true;
        }
        return false;
    }
}
