import java.io.*;
import java.util.StringTokenizer;

public class GameDevelopment {
    static int userX;
    static int userY;
    static int userD;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] mapSize = br.readLine().split(" ");

        Integer mapHeight = Integer.parseInt(mapSize[0]);
        Integer mapWidth = Integer.parseInt(mapSize[1]);

        String[] user = br.readLine().split(" ");
        userX = Integer.parseInt(user[0]);
        userY = Integer.parseInt(user[1]);
        userD = Integer.parseInt(user[2]);

        // 맵 정보 완성
        int[][] map = new int[mapHeight][mapWidth];
        boolean[][] visit = new boolean[mapHeight][mapWidth];

        for (int i = 0; i < mapHeight; i++) {
            StringTokenizer row = new StringTokenizer(br.readLine());
            for(int j = 0; j < mapWidth; j++) {
                map[i][j] = Integer.parseInt(row.nextToken());
            }
        }

        // 플레이어가 최초로 서있는 위치는 방문 한것으로 체크
        visit[userY][userX] = true;

        // 플레이어가 최초로 서 있는 위치도 방문한 횟수에 추가
        int visitCount = 1;

        // 네번 모두 회전 했을 때
        int turnCount = 0;

        while (true) {
            // 왼쪽으로 회전
            turnUser();

            // 회전하고나서 정면의 위치(이동하려는 위치)
            int nx = userX + dx[userD];
            int ny = userY + dy[userD];

            // 이동가능하면 이동하고 방문카운트 증가
            if(!visit[nx][ny] && map[nx][ny] == 0) {
                userX = nx;
                userY = ny;
                visit[nx][ny] = true;
                visitCount += 1;
                turnCount = 0;
                continue;
            } else { // 이동 못하면 회전 횟수만 증가
                turnCount += 1;
            }

            // 4번 회전했는데 이동 못하면 뒤로 빠꾸
            if (turnCount == 4) {
                nx = userX - dx[userD];
                ny = userY - dy[userD];

                // 빠꾸 가능하면 유저의 위치 이동
                if(map[nx][ny] == 0) {
                    userX = nx;
                    userY = ny;
                    turnCount = 0;
                } else {
                    break; // 빠꾸 불가능하면 끝
                }
            }
        }

        System.out.println(visitCount);
    }

    private static void turnUser() {
        userD = userD - 1;
        if(userD < 0) userD = 3;
    }
}
