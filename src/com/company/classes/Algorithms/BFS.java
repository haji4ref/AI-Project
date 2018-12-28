package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS extends Algorithm {


    public BFS(Graph graph, Node start) {
        super(graph, start);
    }

    @Override
    public void execute() {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[this.graph.V];

        // Create a queue for BFS
        LinkedList<Node> queue = new LinkedList<Node>();

        // Mark the current node as visited and enqueue it
        visited[this.start.getId()] = true;
        queue.add(this.start);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            this.start = queue.poll();
            System.out.print(this.start.getId() + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            ListIterator<Node> i = this.graph.adj[this.start.getId()].listIterator();
            while (i.hasNext()) {
                Node n = i.next();
                if (!visited[n.getId()]) {
                    visited[n.getId()] = true;
                    queue.add(n);
                }
            }
        }

    }
}
