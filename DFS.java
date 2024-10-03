import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DFS {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < N+1; i++) {
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> row = new ArrayList<>();
            while (st.hasMoreTokens()) {
                row.add(Integer.parseInt(st.nextToken()));   
            }
            graph.add(row);
        }

        boolean[] visited = new boolean[N + 1];

        dfs(graph, 1, visited);
    }

    static void dfs(List<ArrayList<Integer>> graph, int s, boolean[] visited) {
        visited[s] = true;
        System.out.print(s + " ");
        for(int i : graph.get(s)) {
            if(visited[i] == false) {
                dfs(graph, i, visited);
            }
        }
    }
}
