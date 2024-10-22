import java.util.Arrays;
import java.util.Scanner;

public class 모험가길드 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int result = 0;
        int currentCnt = 0;
        for (int i : A) {
            currentCnt++;
            if(i <= currentCnt) {
                result++;
                currentCnt = 0;
            }
        }
        
        System.out.println(result);
    }
}
