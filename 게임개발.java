import java.util.Scanner;

/*
 * N*N 크기의 정사각형 좌표평면이 주어진다. 육지는 0, 바다는 1이고, 캐릭터의 시작 육지 위치가 주어진다.
 * 캐릭터가 바라보는 방향은 0-북쪽, 1-동쪽, 2-남쪽, 3-서쪽 이다.
 * 1. 캐릭터가 바라보는 방향에서 왼쪽방향에 아직 가보지 않은 칸이 있다면, 그곳으로 이동. 왼쪽방향에 가보지 않은 칸이 없다면, 왼쪽으로 회전만 한다.
 * 2. 만약 네 방향이 모두 가본칸이거나 바다로 되어 있는 경우, 바라보는 방향은 유지한채로 한 칸 뒤로 이동한다. 만약 뒤쪽 방향이 바다인 경우 움직임을 끝낸다.
 */

public class 게임개발 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int x = sc.nextInt();
        int y = sc.nextInt();
        int d = sc.nextInt();

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) visited[i][j] = true;
                else visited[i][j] = false;
            }
        }
        visited[x][y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int cnt = 1;
        int turnCnt = 0;
        while(true) {
            if(d-1 == -1) d = 3;
            else d--;

            int nx = x + dx[d];
            int ny = y + dy[d];


            if(map[nx][ny] == 0 && visited[nx][ny] == false) {
                x = nx;
                y = ny;
                visited[x][y] = true;
                cnt++;
                turnCnt = 0;
            } else {
                turnCnt++;
            }

            if(turnCnt == 4) {
                nx = x - dx[d];
                ny = y - dy[d];

                if(map[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    turnCnt = 0;
                } else {
                    break;
                }
            }
        }

        System.out.println(cnt);

    }
}
