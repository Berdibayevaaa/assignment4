 Assignment 4 IT-2501 Berdibayeva Sayazhan
<img width="1841" height="1108" alt="image" src="https://github.com/user-attachments/assets/84d8bb50-8079-437c-a83b-400556300c9e" />
<img width="1900" height="1142" alt="image" src="https://github.com/user-attachments/assets/03367842-56ea-405d-aa51-816c4c260493" />

This project demonstrates graph traversal algorithms in Java.

A graph consists of vertices and edges.

- Vertex = node
- Edge = connection between nodes

In this project, the graph is represented using an adjacency list.

The project implements:

- Breadth-First Search (BFS)
- Depth-First Search (DFS)

The program tests graphs with:

- 10 vertices
- 30 vertices
- 100 vertices



 Class Descriptions

 Vertex Class

The Vertex class represents one node in the graph.

Field:

- id — unique identifier

Methods:

- constructor
- getId()
- toString()



 Edge Class

The Edge class represents a connection between two vertices.

Fields:

- source
- destination

Methods:

- constructor
- getters
- toString()


## Graph Class

The Graph class stores the graph using an adjacency list.

Main methods:

- addVertex()
- addEdge()
- printGraph()
- bfs()
- dfs()

## Experiment Class

The Experiment class creates graphs and runs BFS and DFS tests.

It also measures execution time using: java System.nanoTime()
Main Class

The Main class starts the program and runs all experiments.

BFS Algorithm

Breadth-First Search visits vertices level by level.

BFS uses a queue.

Steps:

Start from a vertex
Mark it as visited
Add it to the queue
Visit neighbours
Repeat until queue is empty

Use cases:

shortest path
social networks
maps

Time complexity:

O(V + E)
DFS Algorithm

Depth-First Search goes as deep as possible before returning back.

DFS uses recursion.

Steps:

Start from a vertex
Mark it as visited
Visit neighbour
Continue deeper
Return back when needed

Use cases:

path finding
cycle detection

Time complexity:

O(V + E)
Experimental Results
Graph Size	BFS Time	DFS Time
10 vertices	1977900 ns	503200 ns
30 vertices	1664300 ns	1179200 ns
100 vertices	4907800 ns	add your DFS time
Observations

As graph size increases, execution time also increases.

BFS and DFS both follow complexity O(V + E).

The traversal order depends on graph structure.

When BFS is Preferred

BFS is useful for shortest path problems in unweighted graphs.

Limitations of DFS

DFS may go very deep and use more memory because of recursion.

DFS also does not always find the shortest path.

Reflection

In this assignment, I learned how graph traversal works in Java.

I learned the difference between BFS and DFS and how adjacency lists store graph connections.

The most difficult part was understanding recursion in DFS and the visited array.

Conclusion

This project helped me understand graph traversal algorithms and graph representation in Java.
