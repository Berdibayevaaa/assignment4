import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjacencyList;

    public Graph(int numberOfVertices) {
        adjacencyList = new ArrayList<>();

        for (int i = 0; i <= numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addVertex(Vertex v) {
        // Vertices are already created in constructor.
        // This method exists because it is required in the assignment.
    }

    public void addEdge(int from, int to) {
        adjacencyList.get(from).add(to);
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");

        for (int i = 1; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");

            for (int neighbor : adjacencyList.get(i)) {
                System.out.print(neighbor + " ");
            }

            System.out.println();
        }
    }

    public void bfs(int start) {
        boolean[] visited = new boolean[adjacencyList.size()];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        System.out.print("BFS: ");

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : adjacencyList.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        System.out.println();
    }

    public void dfs(int start) {
        boolean[] visited = new boolean[adjacencyList.size()];

        System.out.print("DFS: ");
        dfsHelper(start, visited);
        System.out.println();
    }

    private void dfsHelper(int current, boolean[] visited) {
        visited[current] = true;
        System.out.print(current + " ");

        for (int neighbor : adjacencyList.get(current)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, visited);
            }
        }
    }
}