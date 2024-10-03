import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFSrecursive {
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

        List<List<Integer>> graph = new ArrayList<>();;
        for(int i = 0; i < N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < M; i++) {
            graph.get(A[i]).add(B[i]);
            graph.get(B[i]).add(A[i]);
        }

        boolean[] visited = new boolean[N+1];
        dfs(graph, 1, visited);
    }

    static void dfs(List<List<Integer>> graph, int pos, boolean[] visited) {
        visited[pos] = true;
        System.out.print(pos + " ");
        for(int i : graph.get(pos)) {
            if(visited[i] == false) {
                dfs(graph, i, visited);
            }
        }
    }
}
