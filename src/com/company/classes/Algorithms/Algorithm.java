package com.company.classes.Algorithms;

import com.company.classes.Graph;
import com.company.classes.Node;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.State;

import java.util.Iterator;
import java.util.LinkedList;

abstract public class Algorithm {
    protected String name;

    protected Problem problem;

    protected State start;

    protected int visitedNumber = 0;

    protected int extendedNodeNumber = 0;

    protected Path path;

    protected int maxMemory;

    protected boolean graphSearch = false;

    public final void printStatus() {
        System.out.println(this.name + " results:");
        System.out.println("- Visited nodes number: " + this.visitedNumber);
        System.out.println("- Extended nodes number: " + this.extendedNodeNumber);
        System.out.println("- Used memory: " + this.maxMemory);
        System.out.println("- Path cost: " + this.getPathCost());
        System.out.println("- Suggested path :");
        this.printPath();

    }

    public Algorithm(Problem problem, State state) {
        this.problem = problem;
        this.start = state;
        this.path = new Path(new LinkedList<State>());
    }

    abstract public Algorithm execute();

    public void incrementVisitedNumber() {
        this.visitedNumber++;
    }

    public void incrementExtendedNumber() {
        this.extendedNodeNumber++;
    }

    public void addNodeToPath(State state) {
        this.path.add(state);
    }

    protected void printPath() {
        Iterator<State> iterator = this.path.listIterator();
        int counter = 0;
        while (iterator.hasNext()) {
            System.out.print(counter + ".");
            iterator.next().printValues();
            counter++;
        }
    }

    private int getPathCost() {
        int sum = 0;
        Iterator<State> iterator = this.path.listIterator();

        while (iterator.hasNext()) {
            sum += iterator.next().getCost();
        }

        return sum;
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
