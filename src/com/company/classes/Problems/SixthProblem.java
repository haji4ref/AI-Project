package com.company.classes.Problems;

import com.company.classes.Graph;
import com.company.classes.MyNodeBuilder;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.StateFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SixthProblem extends GreedyProblem {
    private int colorNum;

    private String[] colorsBag = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    private String[] colors = new String[]{};

    private Graph graph;

    public int nodes;

    public SixthProblem() {
        this.colorNum = 3;
        this.nodes = 4;
        this.initGraph();
        for (int i = 0; i < this.colorNum; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, colorsBag.length);
            this.colors[i] = this.colorsBag[random];
        }
        this.setInitState();

    }

    public String getRandomColor() {
        int random = ThreadLocalRandom.current().nextInt(0, this.colorNum);
        return this.colors[random];
    }

    private void initGraph() {
        this.graph = new Graph(this.nodes);

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
        // k = 4
        this.geneticStates = new State[]{
                StateFactory.create("r", "r", "g", "b"),
                StateFactory.create("r", "g", "g", "b"),
                StateFactory.create("b", "r", "g", "b"),
                StateFactory.create("g", "g", "g", "b"),
        };
    }

    public State[] getRandomChilds(int k) {
        return new State[]{
                StateFactory.create("r", "r", "g", "b"),
                StateFactory.create("r", "g", "g", "b"),
                StateFactory.create("b", "r", "g", "b"),
                StateFactory.create("g", "g", "g", "b"),
        };
//        State[] states = new State[k];
//        for (int i = 0; i < k; i++) {
//            State state = new State(new String[this.nodes]);
//            for (int j = 0; j < nodes; j++) {
//                int random = ThreadLocalRandom.current().nextInt(0, colors.length);
//                state.setValue(j, this.colors[random]);
//            }
//            states[i] = state;
//        }
//        return states;
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
