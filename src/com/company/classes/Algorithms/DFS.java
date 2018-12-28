package com.company.classes.Algorithms;

import com.company.classes.Graph;

import java.util.Iterator;

public class DFS extends Algorithm {
    public DFS(Graph graph, int start) {
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
    private void DFSUtil(int v, boolean[] visited) {
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = this.graph.adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
}
