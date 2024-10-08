import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[M];
        int[] B = new int[M];
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
        }

        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        boolean[] visited = new boolean[N+1];
        visited[1] = true;
        while (q.size() >= 1) {
            int pos = q.poll();
            System.out.print(pos + " ");
            for(int i : graph.get(pos)) {
                if(visited[i] == false) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}
