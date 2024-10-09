import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class 다이크스트라 {
    public static void main(String args[]) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1, 2);
        graph.addEdge(0, 3, 8);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(2, 4, 1);
        graph.addEdge(3, 4, 6);
        graph.addEdge(4, 5, 5);

        Dijkstra dijkstra = new Dijkstra(graph);
        int[] shortestPath = dijkstra.findShortestPaths(0);

        for (int i = 0; i < shortestPath.length; i++) {
            System.out.println(shortestPath[i]);
        }
    }
    
}

class Dijkstra {
    private final Graph graph;

    Dijkstra(Graph graph) {
        this.graph = graph;
    }

    public int[] findShortestPaths(int start) {
        int nodeCount = graph.getVerticesCount();
        int[] distances = new int[nodeCount];
        boolean[] visited = new boolean[nodeCount];

        PriorityQueue<Edge> minHeap = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        minHeap.add(new Edge(start, 0));

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[start] = 0;

        while (!minHeap.isEmpty()) {
            Edge currentEdge = minHeap.poll();
            int currentTarget = currentEdge.target;

            if (visited[currentTarget]) continue;
            visited[currentTarget] = true;

            for(Edge neighborEdge : graph.getNeighbors(currentTarget)) {
                if(visited[neighborEdge.target]) continue;

                int newDist = distances[currentTarget] + neighborEdge.weight;
                if(newDist < distances[neighborEdge.target]) {
                    distances[neighborEdge.target] = newDist;
                    minHeap.add(new Edge(neighborEdge.target, newDist));
                }
            }
        }

        return distances;
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
    private final List<List<Edge>> adjacencyList;

    Graph(int vertices) {
        adjacencyList = new ArrayList<>(vertices);
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    void addEdge(int source, int target, int weight) {
        adjacencyList.get(source).add(new Edge(target, weight));
    }

    List<Edge> getNeighbors(int vertex) {
        return adjacencyList.get(vertex);
    }

    int getVerticesCount() {
        return adjacencyList.size();
    }
}