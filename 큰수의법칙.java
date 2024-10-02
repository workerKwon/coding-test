// 그리디 알고리즘
/*
 * 더할 수 있는 횟수 M
 * 연속하여 K번을 초과하여 더해질 수 없다.
 * 숫자 배열의 크기 N
 */

import java.util.Arrays;
import java.util.Scanner;

public class 큰수의법칙 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] A = new int[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int first = A[N-1];
        int second = A[N-2];

        int result = 0;
        while (true) {
            for(int i = 0; i < K; i++) {
                if(M == 0) break;
                result += first;
                M--;
            }

            if(M == 0) break;
            result += second;
            M--;
        }

        System.out.println(result);
    }
}
