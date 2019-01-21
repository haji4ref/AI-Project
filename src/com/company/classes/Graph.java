package com.company.classes;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
    public int V; // No. of vertices
    public ArrayList<Node>[] adj; //Adjacency Lists

    // Constructor
    public Graph(int numberOfNodes) {
        this.V = numberOfNodes;
        this.adj = new ArrayList[numberOfNodes];
        for (int i = 0; i < numberOfNodes; ++i)
            this.adj[i] = new ArrayList<Node>();
    }

    // Function to add an edge into the graph
    public void addEdge(Node v, Node w) {
        this.adj[v.getId()].add(w);
        this.adj[w.getId()].add(v);
    }

}
