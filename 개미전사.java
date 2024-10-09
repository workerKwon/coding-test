import java.util.Scanner;

public class 개미전사 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int[] dp = new int[N+1];
        dp[1] = A[0];
        dp[2] = Math.max(dp[1], A[1]);
        for(int i = 3; i < N+1; i++) {
            dp[i] = Math.max(dp[i-2] + A[i-1], dp[i-1]);
        }

        System.out.println(dp[N]);
    }
}
