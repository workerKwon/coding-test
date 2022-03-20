import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.SortOrder;

/**
 * Greedy1
 * 큰 수의 법칙
 * 배열의 크기가 n, 숫자가 더해지는 횟수 m, 특정한 인덱스에 해당하는 수가 연속해서 k번 초과하여 더해질 수 없는 법칙
 * m번 더해서 나올 수 있는 가장 큰 수 구하기.
 */
public class Greedy1 {

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    private static void secondMethod() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int first = arr[n-1];
        int second = arr[n-2];

        /**
         * 반복되는 패턴을 수학적으로 이용
         * 총 더해야하는 횟수 / 반복되는 패턴 = 패턴이 반복되는 횟수
         * 패턴이 반복되는 횟수 * 하나의 인덱스를 반복할 수 있는 최대 횟수 = 가장 큰수를 더해야하는 횟수
         *     + 패턴이 반복되는 횟수가 나누어 떨어지지 않을 때는 나머지만큼 가장 큰수를 더해줘야한다.
         */
        int cnt = (m / (k + 1) * k) + (m % (k + 1));

        int result = 0;
        result += first * cnt;
        result += (m - cnt) * second;

        System.out.println(result);
    }

    private static void firstMethod() {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int k = scanner.nextInt();

        int[] data = new int[n];
        for(int i = 0; i < data.length; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);
        int first = data[n-1];
        int second = data[n-2];

        int result = 0;

        while (true) {
            for (int i = 0; i < k; i++) {
                if (m == 0) {
                    break;
                }
                result += first;
                m--;
            }
            if(m == 0) {
                break;
            }
            result += second;
            m--;
        }

        System.out.println(result);
    }
}

