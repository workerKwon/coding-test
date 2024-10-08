import java.util.Arrays;
import java.util.Scanner;

/*
 * N개의 떡, 떡의 길이는 모두 다를 수 있다.
 * H 높이의 절단기로 떡을 자르면 잘려나간 윗부분을 손님들이 가져갈 수 있다.
 * 손님이 요청한 총 길이가 M일 때 적어도 M만큼의 떡을 얻기 위해 절단기에 설정할 수 있는 높이의 최댓값 구하기
 * 떡 하나당 높이는 10억보다 작거나 같은 양의 정수 또는 0이다.
 */

public class 떡자르기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int target = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        Arrays.sort(A);
        int result = binary_search(A, target, 0, A[N-1]);
        System.out.println(result);
    }

    static int binary_search(int[] arr, int target, int start, int end) {
        if(start > end) return end;
        int mid = (start + end) / 2;
        int sum = 0;
        for(int i : arr) {
            if(i > mid) sum += i - mid;
        }

        if(target > sum) {
            return binary_search(arr, target, start, mid-1);
        } else if (target < sum) {
            return binary_search(arr, target, mid+1, end);
        } else {
            return mid;
        }
    }
}
