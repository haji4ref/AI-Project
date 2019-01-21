package com.company.classes.Problems;

import com.company.classes.Graph;
import com.company.classes.MyNodeBuilder;
import com.company.classes.Node;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SixthProblem extends GreedyProblem {
    private int colorNum;

    private String[] colorsBag = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    private String[] colors = new String[]{};

    private Graph graph;

    public SixthProblem() {
        this.initGraph();
        this.colorNum = 3;
        for (int i = 0; i < this.colorNum; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, colorsBag.length);
            this.colors[i] = this.colorsBag[random];
        }

    }

    private void initGraph() {
        this.graph = new Graph(4);

        this.graph.addEdge(MyNodeBuilder.instance("0"), MyNodeBuilder.instance("1"));
        this.graph.addEdge(MyNodeBuilder.instance("0"), MyNodeBuilder.instance("2"));
        this.graph.addEdge(MyNodeBuilder.instance("0"), MyNodeBuilder.instance("3"));
        this.graph.addEdge(MyNodeBuilder.instance("2"), MyNodeBuilder.instance("3"));
        this.graph.addEdge(MyNodeBuilder.instance("1"), MyNodeBuilder.instance("2"));

    }

    @Override
    public int valueFunction(State state) {
        int sum = 0;
        for (int i = 0; i < state.length(); i++) {
            for (int j = 0; j < this.graph.adj[i].size(); j++) {
                if (this.graph
                        .adj[i]
                        .get(j)
                        .getColor()
                        .equals(state.getValue(i))
                )
                    sum++;
            }
        }
        return sum;
    }

    @Override
    protected void setInitState() {
        // nothing
    }

    @Override
    protected void setActions() {

    }

    @Override
    public Action[] possibleActions(State state) {
        return new Action[0];
    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        return null;
    }

    @Override
    public boolean goalTest(State state) {
        return false;
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        return 0;
    }
}
