package com.company.classes;

import java.util.LinkedList;

public class Graph {
    public int V; // No. of vertices
    public LinkedList[] adj; //Adjacency Lists

    // Constructor
    public Graph(int v) {
        this.V = v;
        this.adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            this.adj[i] = new LinkedList<Node>();
    }

    // Function to add an edge into the graph
    public void addEdge(Node v, Node w) {
        this.adj[v.getId()].add(w);
    }

    public LinkedList<Node> possibleStates(int id) {
        return this.adj[id];
    }
}
