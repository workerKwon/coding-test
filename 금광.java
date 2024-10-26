import java.util.*;
import java.io.*;

/*
 * n * m 크기의 금광. 각 칸은 특정한 크기의 금이 들어 있음.
 * 맨 처음에는 첫번째 열의 어느 행에서든 출발이 가능함.
 * 이후에 m번에 걸쳐서 매번 오른쪽 위, 오른쪽, 오른쪽 아래 3가지 중 하나의 위치로 이동해야함.
 * 결과적으로 채굴자가 얻을 수 있는 금의 최대 크기를 구하기
 * 
 * 첫번째 줄에 금광의 개수 T 입력
 * 금광마다 첫째 줄에 n, m이 공백으로 구분됨.
 * 둘째 줄에 n * m개의 위치에 매장된 금의 개수가 공백으로 구분되어 입력됨.
 * 
 * 금광마다 채굴자가 얻을 수 있는 금의 최대 크기를 출력.
 */
public class 금광 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 금광의 개수
        int T = Integer.parseInt(st.nextToken());

        // n * m 크기의 금광이 들어갈 리스트
        List<int[][]> arrList = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            // n * m 크기의 금광 생성
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            int[][] arr = new int[row][col];

            // 각 칸의 금의 개수를 금광에 입력
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < row * col; j++) {
                arr[j / col][j % col] = Integer.parseInt(st.nextToken());
            }
            arrList.add(arr);
        }

        List<int[][]> dpList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int[][] arr = arrList.get(i);

            // dp 첫번째열에 금광의 첫번째 열 금의 개수 입력
            int[][] dp = new int[arr.length][arr[0].length];
            for (int j = 0; j < arr.length; j++) {
                dp[j][0] = arr[j][0];
            }
            dpList.add(dp);
        }

        for (int i = 0; i < T; i++) {
            int[][] arr = arrList.get(i);
            int[][] dp = dpList.get(i);
            int row = dp.length;
            int col = dp[0].length;

            // dp의 오른쪽 위, 오른쪽, 오른쪽 아래의 값중 가장 큰 값을 찾아서 dp에 입력
            for (int j = 1; j < col; j++) {
                for (int k = 0; k < row; k++) {
                    dp[k][j] = arr[k][j] + findMax(k, j, dp, row - 1);
                }
            }
        }

        for (int i = 0; i < T; i++) {
            int[][] dp = dpList.get(i);
            int col = dp[0].length - 1;
            int max = dp[0][col];
            for (int j = 1; j < dp.length; j++) {
                max = Math.max(max, dp[j][col]);
            }
            System.out.println(max);
        }
    }

    // dp를 채우기 위해 오른쪽 위, 오른쪽, 오른쪽 아래의 값중 가장 큰 값을 찾는 메서드
    public static int findMax(int rowI, int colI, int[][] dp, int maxRow) {
        int temp = dp[rowI][colI - 1];
        if (rowI - 1 >= 0) {
            temp = Math.max(dp[rowI - 1][colI - 1], temp);
        }

        if (rowI + 1 <= maxRow) {
            temp = Math.max(dp[rowI + 1][colI - 1], temp);
        }

        return temp;
    }
}
