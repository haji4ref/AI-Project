package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;

import java.util.Iterator;

public class DFS extends Algorithm {
    public DFS(Graph graph, Node start) {
        super(graph, start);
    }

    @Override
    public void execute() {
// Mark all the vertices as not visited(set as
        // false by default in java)
        boolean[] visited = new boolean[this.graph.V];

        // Call the recursive helper function to print DFS traversal
        DFSUtil(this.start, visited);
    }

    // A function used by DFS
    private void DFSUtil(Node v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v.getId()] = true;
        System.out.print(v.getId() + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Node> i = this.graph.adj[v.getId()].listIterator();
        while (i.hasNext()) {
            Node n = i.next();
            if (!visited[n.getId()])
                DFSUtil(n, visited);
        }
    }
}
