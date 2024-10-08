import java.util.Scanner;

public class 부품찾기계수정렬 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++) {
            B[i] = sc.nextInt();
        }

        int[] arr = new int[1000000];
        for (int i : A) {
            arr[i] += 1;
        }

        for (int i : B) {
            if(arr[i] >= 1) System.out.print("Yes ");
            else System.out.print("No ");
        }
    }
}
