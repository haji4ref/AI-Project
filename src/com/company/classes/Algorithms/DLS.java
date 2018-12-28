package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;

import java.util.Iterator;

public class DLS extends Algorithm {
    private int limit;

    public DLS(Graph graph, Node start, int limit) {
        super(graph, start);

        this.setLimit(limit);
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Override
    public void execute() {
// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[this.graph.V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(this.start, visited, 0);
    }

    // A function used by DFS
    private void DFSUtil(Node v, boolean[] visited, int currentDepth) {
        // Mark the current node as visited and print it
        visited[v.getId()] = true;
        System.out.print(v.getId() + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Node> i = this.graph.adj[v.getId()].listIterator();
        while (i.hasNext()) {
            Node n = i.next();
            if (!visited[n.getId()] && this.limit > currentDepth) {
                DFSUtil(n, visited, currentDepth + 1);
            }
        }
    }
}
