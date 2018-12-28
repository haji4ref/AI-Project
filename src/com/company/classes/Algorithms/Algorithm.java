package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.State;

import java.util.Iterator;
import java.util.LinkedList;

abstract public class Algorithm {
    protected Problem problem;

    protected State start;

    protected int visitedNumber = 0;

    protected int extendedNodeNumber = 0;

    protected Path path;

    protected int maxMemory;

    protected boolean graphSearch = false;

    public Algorithm(Problem problem, State state) {
        this.problem = problem;
        this.start = state;
        this.path = new Path(new LinkedList<State>());
    }

    abstract public void execute();

    public void incrementVisitedNumber() {
        this.visitedNumber++;
    }

    public void incrementExtendedNumber() {
        this.extendedNodeNumber++;
    }

    public void addNodeToPath(State state) {
        this.path.add(state);
    }

    protected void prinPath() {
        Iterator<State> iterator = this.path.listIterator();
        int counter = 0;
        while (iterator.hasNext()) {
            System.out.print(counter + ".");
            iterator.next().printValues();
            counter++;
        }
    }

    public void setMaxMemory(int maxMemory) {
        this.maxMemory = this.maxMemory > maxMemory ? this.maxMemory : maxMemory;
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
