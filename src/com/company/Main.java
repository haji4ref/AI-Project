package com.company;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.DFS;
import com.company.classes.Algorithms.LDS;
import com.company.classes.Graph;

public class Main {

    public static void main(String[] args) {
        Graph graph = new Graph(8);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);
        graph.addEdge(3, 6);
        graph.addEdge(6, 7);

//        Algorithm algorithm = new BFS(graph, 0);
        Algorithm algorithm = new LDS(graph, 0, 2);

        algorithm.execute();
    }
}
