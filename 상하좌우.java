import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class 상하좌우 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        br = new BufferedReader(new InputStreamReader(System.in));
        String[] move = br.readLine().split(" ");
        System.out.println(move[0]);
        
        int x = 1;
        int y = 1;

        for(String d : move) {
            if(d.equals("R") && y < N) y++;
            if(d.equals("L") && y > 1) y--;
            if(d.equals("U") && x > 1) x--;
            if(d.equals("D") && x < N) x++;
        }

        System.out.println(x + " " + y);
    }
}
