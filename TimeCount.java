import java.util.Scanner;

public class TimeCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        iterator(n);

        mathematical(n);
    }

    private static void mathematical(int n) {
        int count = 0;
        int minutes = 15 * 60; // (3, 13, 23, 30, 31,32,33,34,35,36,37,38,39, 43, 53) 15개분 * 60초
        int seconds = 15 * 45; // (3, 13, 23, 30, 31,32,33,34,35,36,37,38,39, 43, 53) 15개초 * 45개분(60개분 - 3이 있는 분(15개))
        for(int i = 0; i <= n; i++) {
            if(i == 3 || i == 13 || i == 23) {
                count = count + 60 * 60;
            } else {
                count = count + minutes + seconds;
            }
        }
        System.out.println(count);
    }

    private static void iterator(int n) {
        int count = 0;
        for(int i = 0; i <= n; i++) {
            for (int j = 0; j < 60; j++) {
                for (int k = 0; k < 60; k++) {
                    if(i % 10 == 3 || j / 10 == 3 || j % 10 == 3 || k / 10 == 3 || k % 10 == 3) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }


}
