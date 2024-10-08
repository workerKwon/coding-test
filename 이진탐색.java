import java.util.Arrays;
import java.util.Optional;
import java.util.Scanner;

public class 이진탐색 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        Arrays.sort(A);
        Optional<Integer> result = binary_search(A, K, 0, N-1);
        if(result.isPresent()) {
            System.out.println(result.get()+1);
        } else {
            System.out.println("원소가 존재하지 않습니다.");
        }
        
    }

    static Optional<Integer> binary_search(int[] arr, int target, int start, int end) {
        if(start > end) return Optional.empty();
        int mid = (start + end) / 2;
        if(target > arr[mid]) {
            return binary_search(arr, target, mid+1, end);
        } else if(target < arr[mid]) {
            return binary_search(arr, target, start, mid-1);
        } else {
            return Optional.of(mid);
        }
    }
}
