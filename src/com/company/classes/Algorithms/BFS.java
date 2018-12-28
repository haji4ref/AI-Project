package com.company.classes.Algorithms;

import com.company.classes.Graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFS extends Algorithm {


    public BFS(Graph graph, int start) {
        super(graph, start);
    }

    @Override
    public void execute() {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean[] visited = new boolean[this.graph.V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[this.start] = true;
        queue.add(this.start);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            this.start = queue.poll();
            System.out.print(this.start + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = this.graph.adj[this.start].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }

    }
}
