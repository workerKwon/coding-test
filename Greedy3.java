import java.util.Scanner;

/**
 * 1이 될때까지
 */
public class Greedy3 {
    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    private static void secondMethod() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int result = 0;

        while(true) {
            // n을 k로 나누어 떨어지는 값으로 바꾼다.
            int target = n / k * k;
            result += n - target; // n을 k로 나눴을 때 나머지는 어짜피 -1 과정에 들어가기 때문에 그냥 나머지를 더한다.
            n = target;
            if(n < k) break; // n을 k로 나눌 수 없으면 반복을 끝내고 n이 1이 될 때 까지 -1을 한다.
            n = n / k; // n을 k로 나누어 떨어뜨릴 수 있는 수로 바꿨기 때문에 나눠준다.
            result++;
        }
        result += n - 1; // n이 k보다 작을 때는 -1만 반복해야하기 때문에 1만 남기기 위해 n-1을 하고 나온 값은 결과에 넣는다.
        System.out.println(result);
    }

    private static void firstMethod() {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;

        while (n != 1) {
            if(n % k == 0) { n = n / k;} 
            else { n--; }
            cnt++;
        }

        System.out.println(cnt);
    }
}
