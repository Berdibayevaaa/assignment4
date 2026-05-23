public class Vertex {
    private int id; // Уникальный идентификатор вершины

    // Конструктор
    public Vertex(int id) {
        this.id = id;
    }

    // Геттер для получения id
    public int getId() {
        return id;
    }

    // Метод для вывода вершины в виде строки
    @Override
    public String toString() {
        return String.valueOf(id);
    }
}