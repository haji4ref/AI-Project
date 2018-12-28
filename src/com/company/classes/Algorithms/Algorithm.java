package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;

import java.util.LinkedList;

abstract public class Algorithm {
    protected Graph graph;

    protected Node start;

    protected int visitedNumber = 0;

    protected int extendedNodeNumber = 0;

    protected LinkedList path;

    protected int maxMemory;

    protected boolean graphSearch = false;

    public Algorithm(Graph graph, Node start) {
        this.graph = graph;
        this.start = start;

        this.path = new LinkedList();

    }

    abstract public void execute();

    public void increamentVistedNumber() {
        this.visitedNumber++;
    }

    public void addToExtendedNodeNumber(int value) {
        this.extendedNodeNumber += value;
    }

    public void addNodeToPath(int value) {

    }

    public Algorithm setGraphSearch(boolean value) {
        this.graphSearch = value;

        return this;
    }

    public Algorithm setGraphSearch() {
        this.graphSearch = true;

        return this;
    }
}
