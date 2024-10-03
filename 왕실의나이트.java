import java.util.Scanner;

/*
 * 8*8 좌표 평면에서 행 위치는 1~8, 열 위치는 a~h로 표현한다.
 * 나이트의 위치가 주어지고, 나이트는 L자 형태로 밖에 움직일 수 없다.
 * 나이트의 위치에서 움직일 수 있는 위치가 몇개나 되는지 구하시오.
 */

public class 왕실의나이트 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String p = sc.nextLine();
        int x = (int) p.charAt(0) - (int) 'a' + 1;
        int y = Character.getNumericValue(p.charAt(1));

        int[][] moves = {{-2, 1}, {-2, -1}, {2, 1}, {2, -1}, {1, -2}, {1, 2}, {-1, -2}, {-1, 2}};

        int cnt = 0;
        for(int i = 0; i < moves.length; i++) {
            if (x + moves[i][0] >= 1 && x + moves[i][0] <= 8 && y + moves[i][1] >= 1 && y + moves[i][1] <= 8) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
