import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 만들수없는금액 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] A = new Integer[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        boolean[] arr = new boolean[1000000];
        Arrays.sort(A, Collections.reverseOrder());
        for (int i = 1; i < 1000000; i++) {
            int k = i;
            for (int j : A) {
                if(k >= j) {
                    k = k-j;
                    if(k == 0) {
                        arr[i] = true;
                    }
                }
            }

            if(arr[i] == false) {
                System.out.println(i);
                break;
            }
        }
    }
}
