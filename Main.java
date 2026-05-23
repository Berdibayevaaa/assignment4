public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        // Запуск всех тестов (включая BFS, DFS и Дейкстру)
        experiment.runMultipleTests();
        experiment.printResults();
    }
}