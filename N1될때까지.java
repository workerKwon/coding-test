import java.util.*;
/*
 * 1. N에서 1을 뺀다
 * 2. N을 K로 나눈다(단, N이 K로 나누어 떨어질 때만 가능)
 */
public class N1될때까지 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        int cnt = 0;
        while(N > 1) {
            if(N % K == 0) {
                N /= K;
                cnt++;
            } else {
                N--;
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
