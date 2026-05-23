import java.util.Random;

public class Experiment {

    public Graph createGraph(int size) {
        Graph graph = new Graph(size);
        Random random = new Random();

        for (int i = 1; i <= size; i++) {
            graph.addVertex(new Vertex(i));
        }

        // Создаем ребра со случайными весами от 1 до 10 для алгоритма Дейкстры
        for (int i = 1; i < size; i++) {
            int randomWeight = random.nextInt(10) + 1; // Вес от 1 до 10
            graph.addEdge(i, i + 1, randomWeight);
        }

        return graph;
    }

    public void runTraversals(Graph graph, String graphName) {
        System.out.println("\n--- " + graphName + " ---");

        // 1. Замер времени для BFS
        long startBFS = System.nanoTime();
        graph.bfs(1);
        long endBFS = System.nanoTime();

        // 2. Замер времени для DFS
        long startDFS = System.nanoTime();
        graph.dfs(1);
        long endDFS = System.nanoTime();

        // 3. Замер времени для Дейкстры (Бонусное задание)
        long startDijkstra = System.nanoTime();
        graph.dijkstra(1); // Запуск алгоритма от первой вершины
        long endDijkstra = System.nanoTime();

        // Вывод результатов времени
        System.out.println("\nExecution Times for " + graphName + ":");
        System.out.println("BFS time     : " + (endBFS - startBFS) + " ns");
        System.out.println("DFS time     : " + (endDFS - startDFS) + " ns");
        System.out.println("Dijkstra time: " + (endDijkstra - startDijkstra) + " ns (Bonus)");
    }

    public void runMultipleTests() {
        Graph small = createGraph(10);
        Graph medium = createGraph(30);
        Graph large = createGraph(100);

        // Печатаем структуру маленького графа (теперь там будут видны и веса)
        small.printGraph();

        // Запуск тестов для всех размеров графов
        runTraversals(small, "Small graph: 10 vertices");
        runTraversals(medium, "Medium graph: 30 vertices");
        runTraversals(large, "Large graph: 100 vertices");
    }

    public void printResults() {
        System.out.println("\nAll tests finished successfully with Dijkstra Bonus!");
    }
}