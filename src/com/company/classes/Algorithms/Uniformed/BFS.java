package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
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

            // extend the current node
            ListIterator<Node> i = this.graph.adj[this.start.getId()].listIterator();
            this.incrementExtendedNumber();
            while (i.hasNext()) {
                // visit the node
                Node n = i.next();
                this.incrementVisitedNumber();
                if (this.graphSearch && !visited[n.getId()]) {
                    visited[n.getId()] = true;
                    queue.add(n);
                } else if (!this.graphSearch) {
                    visited[n.getId()] = true;
                    queue.add(n);
                }
                // compare current queue size to maxMemory
                this.setMaxMemory(queue.size());
            }
        }
    }
}
