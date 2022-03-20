import java.util.Arrays;
import java.util.Scanner;

/**
 * 각 row 별 가장 작은 수 중에서 가장 큰 수 뽑기
 */
public class Greedy2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = 0;

        int[] rowArr = new int[m];

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                rowArr[j] = sc.nextInt();
            }

            int min = Arrays.stream(rowArr).min().getAsInt();
            result = Math.max(result, min);
        }

        System.out.println(result);
    }
}
