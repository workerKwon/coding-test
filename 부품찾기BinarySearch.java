import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;
/*
 * N종류의 부품 A중에서 M종류의 부품 B가 모두 있는지 확인하는 문제
 * 부품수가 많아졌을 때를 대비해서 이진탐색으로 logN 복잡도로 해결하는 방법
 */
public class 부품찾기BinarySearch {
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
        Arrays.sort(A);

        for (int i : B) {
            Optional<Integer> result = binary_search(A, i, 0, N-1);
            if(result.isPresent()) {
                System.out.print("Yes ");
            } else {
                System.out.print("No ");
            }
        }

        sc.close();

    }

    static Optional<Integer> binary_search(int[] arr, int target, int start, int end) {
        if(start > end) return Optional.empty();
        int mid = (start + end) / 2;
        if(target > arr[mid]) return binary_search(arr, target, mid+1, end);
        else if(target < arr[mid]) return binary_search(arr, target, start, mid-1);
        else return Optional.of(mid);
    }
}
