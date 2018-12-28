package com.company.classes.Algorithms;

import com.company.classes.Graph;

public class Algorithm implements AlgorithmInterface {
    protected Graph graph;

    protected int start;

    public Algorithm(Graph graph,int start) {
        this.graph = graph;
        this.start = start;
    }

    @Override
    public void execute() {

    }
}
