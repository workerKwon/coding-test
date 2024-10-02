import java.util.Scanner;
/*
 * 각 행에서 가장 작은 숫자들 중에서 가장 큰 수의 카드
 * 행 N, 열 M
 * N*M개의 카드 숫자 입력
 */
//
public class 숫자카드게임 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] A = new int[N][M];

        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] = sc.nextInt();
            }
            result = Math.max(result, min(A[i]));
        }

        System.out.println(result);

    }

    static int min(int[] a) {
        int min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i]) min = a[i];
        }

        return min;
    }
}
