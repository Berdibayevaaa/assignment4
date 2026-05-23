import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private ArrayList<ArrayList<Integer>> adjacencyList;
    private int[][] weights;

    public Graph(int numberOfVertices) {
        adjacencyList = new ArrayList<>();
        weights = new int[numberOfVertices + 1][numberOfVertices + 1];

        for (int i = 0; i <= numberOfVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    public void addVertex(Vertex v) {

    }

    public void addEdge(int from, int to) {
        addEdge(from, to, 1);
    }

    public void addEdge(int from, int to, int weight) {
        adjacencyList.get(from).add(to);
        weights[from][to] = weight; // Сохраняем вес ребра
    }

    public void printGraph() {
        System.out.println("Graph adjacency list:");

        for (int i = 1; i < adjacencyList.size(); i++) {
            System.out.print(i + " -> ");

            for (int neighbor : adjacencyList.get(i)) {
                // Печатаем соседа и вес ребра до него
                System.out.print(neighbor + "(w:" + weights[i][neighbor] + ") ");
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

    public void dijkstra(int start) {
        int verticesCount = adjacencyList.size();
        int[] distances = new int[verticesCount];
        boolean[] visited = new boolean[verticesCount];

        for (int i = 0; i < verticesCount; i++) {
            distances[i] = Integer.MAX_VALUE; // Изначально расстояния бесконечны
            visited[i] = false;
        }
        distances[start] = 0; // До самого себя расстояние 0

        // Основной цикл алгоритма Дейкстры
        for (int i = 1; i < verticesCount; i++) {
            int minVertex = -1;
            int minDistance = Integer.MAX_VALUE;

            // Находим неиспользованную вершину с минимальным расстоянием
            for (int j = 1; j < verticesCount; j++) {
                if (!visited[j] && distances[j] < minDistance) {
                    minDistance = distances[j];
                    minVertex = j;
                }
            }

            if (minVertex == -1) break; // Если больше нет доступных вершин
            visited[minVertex] = true;

            for (int neighbor : adjacencyList.get(minVertex)) {
                if (!visited[neighbor]) {
                    int edgeWeight = weights[minVertex][neighbor];

                    if (distances[minVertex] != Integer.MAX_VALUE &&
                            distances[minVertex] + edgeWeight < distances[neighbor]) {
                        distances[neighbor] = distances[minVertex] + edgeWeight;
                    }
                }
            }
        }

        System.out.println("\n--- Dijkstra Shortest Paths from Vertex " + start + " ---");
        for (int i = 1; i < distances.length; i++) {
            String res = (distances[i] == Integer.MAX_VALUE) ? "Unreachable" : String.valueOf(distances[i]);
            System.out.println("To vertex " + i + " : " + res);
        }
    }
}