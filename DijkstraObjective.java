import java.util.*;

public class DijkstraObjective {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        Graph graph = new Graph(N);
        for (int i = 0; i < M; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }

        Dijkstra dijkstra = new Dijkstra(graph);
        int[] distance = dijkstra.findShortestPath(0);
        for (int i = 0; i < N; i++) {
            System.out.println(distance[i]);
        }

        sc.close();
        
    }
}

class Edge {
    int target;
    int weight;
    Edge(int target, int weight) {
        this.target = target;
        this.weight = weight;
    }
}

class Graph {
    private final List<List<Edge>> graph;

    Graph(int nodesCnt) {
        graph = new ArrayList<>(nodesCnt);
        for (int i = 0; i < nodesCnt; i++) {
            graph.add(new ArrayList<Edge>());
        }
    }

    void addEdge(int source, int target, int weight) {
        graph.get(source).add(new Edge(target, weight));
    }

    int getNodeCnt() {
        return graph.size();
    }

    List<Edge> getNeighborNodes(int target) {
        return graph.get(target);
    }
}

class Dijkstra {
    private final Graph graph;

    Dijkstra(Graph graph) {
        this.graph = graph;
    }

    int[] findShortestPath(int start) {
        int totalNodeCnt = graph.getNodeCnt();
        int[] distance = new int[totalNodeCnt];
        boolean[] visited = new boolean[totalNodeCnt];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        minHeap.add(new Edge(start, 0));
        while (!minHeap.isEmpty()) {
            Edge currentNode = minHeap.poll();
            int currentTarget = currentNode.target;

            if(visited[currentTarget]) continue;
            visited[currentTarget] = true;

            for (Edge neighborEdge : graph.getNeighborNodes(currentTarget)) {
                int neighborTarget = neighborEdge.target;
                if(visited[neighborTarget]) continue;
                
                int newDist = distance[currentTarget] + neighborEdge.weight;
                if(newDist < distance[neighborTarget]) {
                    distance[neighborTarget] = newDist;
                    minHeap.add(new Edge(neighborTarget, newDist));
                }
            }
        }

        return distance;
    }
}