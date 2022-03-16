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
        Scanner scanner = new Scanner(System.in);

        int n;
        n = scanner.nextInt();
        int m;
        m = scanner.nextInt();
        int k;
        k = scanner.nextInt();

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