import java.util.Scanner;

/*
 * 정수 N이 주어지면 00시 00분 00초부터 N시 59분 59초까지 3이 하나라도 포함되는 모든 경우의 수를 구하기
 */

public class 시각 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int cnt = 0;
        for(int i = 0; i <= N; i++) {
            for(int j = 0; j < 60; j++) {
                for(int k = 0; k < 60; k++) {
                    String a = Integer.toString(i) + Integer.toString(j) + Integer.toString(k);
                    if(a.contains("3")) {
                        cnt++;
                    }
                }
            }
        }

        System.out.println(cnt);
        sc.close();
    }
}
