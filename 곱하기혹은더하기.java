import java.util.Scanner;

public class 곱하기혹은더하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            int integer = S.charAt(i) - '0';
            if(result == 0 || integer == 1) {
                result += integer;
            } else {
                result *= integer;
            }
        }

        System.out.println(result);
        sc.close();
    }
}
