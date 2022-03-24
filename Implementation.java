import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Implementation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        String[] plans = sc.nextLine().split(" ");
        sc.close();

        int x = 1;
        int y = 1;
        Map<String, Integer> types = new HashMap<>();
        types.put("U", -1);
        types.put("D", 1);
        types.put("L", -1);
        types.put("R", 1);

        for (String plan : plans) {
            int nx = x;
            int ny = y;
            if(plan.equals("U") || plan.equals("D")) {
                nx = x + types.get(plan);
            } else if (plan.equals("L") || plan.equals("R")) {
                ny = y + types.get(plan);
            }

            if(nx < 1 || nx > n || ny < 1 || ny > n) continue;

            x = nx;
            y = ny;
        }

        System.out.println(x + ", " + y);

    }
}