import java.util.Scanner;

public class 문자열뒤집기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        String[] A = S.split("1");
        String[] B = S.split("0");

        int oneCnt = 0;
        for (String bString : B) {
            if(!bString.isEmpty()) {
                oneCnt++;
            }
        }

        int zeroCnt = 0;
        for (String AString : A) {
            if(!AString.isEmpty()) {
                zeroCnt++;
            }
        }

        System.out.println(Math.min(oneCnt, zeroCnt));
        sc.close();
    }
}
