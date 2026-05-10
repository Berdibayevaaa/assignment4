public class Experiment {

    public Graph createGraph(int size) {
        Graph graph = new Graph(size);

        for (int i = 1; i <= size; i++) {
            graph.addVertex(new Vertex(i));
        }

        for (int i = 1; i < size; i++) {
            graph.addEdge(i, i + 1);
        }

        return graph;
    }

    public void runTraversals(Graph graph, String graphName) {
        System.out.println("\n--- " + graphName + " ---");

        long startBFS = System.nanoTime();
        graph.bfs(1);
        long endBFS = System.nanoTime();

        long startDFS = System.nanoTime();
        graph.dfs(1);
        long endDFS = System.nanoTime();

        System.out.println("BFS time: " + (endBFS - startBFS) + " ns");
        System.out.println("DFS time: " + (endDFS - startDFS) + " ns");
    }

    public void runMultipleTests() {
        Graph small = createGraph(10);
        Graph medium = createGraph(30);
        Graph large = createGraph(100);

        small.printGraph();

        runTraversals(small, "Small graph: 10 vertices");
        runTraversals(medium, "Medium graph: 30 vertices");
        runTraversals(large, "Large graph: 100 vertices");
    }

    public void printResults() {
        System.out.println("\nAll tests finished.");
    }
}