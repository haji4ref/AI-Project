package com.company.classes.Problems;

import com.company.classes.Graph;
import com.company.classes.MyNodeBuilder;
import com.company.classes.Node;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.StateFactory;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class SixthProblem extends GreedyProblem {
    private int colorNum;

    private String[] colorsBag = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};

    private String[] colors;

    private Graph graph;

    public int nodes;

    public SixthProblem() {
        this.colorNum = 3;
        this.nodes = 4;
        this.initGraph();
        // init colors
        this.colors = new String[this.colorNum];
        ArrayList<String> tmpColors = new ArrayList<>();
        int counter = 0;
        while (counter < this.colorNum) {
            int random = ThreadLocalRandom.current().nextInt(0, colorsBag.length);
            if (!tmpColors.contains(this.colorsBag[random])) {
                tmpColors.add(this.colorsBag[random]);
                this.colors[counter++] = this.colorsBag[random];
            }
        }
        this.setInitState();

    }

    public String getRandomColor() {
        int random = ThreadLocalRandom.current().nextInt(0, this.colorNum);
        return this.colors[random];
    }

    private void initGraph() {
        this.graph = new Graph(this.nodes);

        this.graph.addNode(
                new Node[]{
                        MyNodeBuilder.instance("0"),
                        MyNodeBuilder.instance("1"),
                        MyNodeBuilder.instance("2"),
                        MyNodeBuilder.instance("3"),
                }
        );

        this.graph.addEdge(this.graph.get(0), this.graph.get(1));
        this.graph.addEdge(this.graph.get(0), this.graph.get(2));
        this.graph.addEdge(this.graph.get(0), this.graph.get(3));
        this.graph.addEdge(this.graph.get(2), this.graph.get(3));
        this.graph.addEdge(this.graph.get(1), this.graph.get(2));

    }

    private void paintGraph(State state) {
        for (int i = 0; i < state.length(); i++) {
            this.graph.get(i).setColor(state.getValue(i));
        }
    }

    @Override
    public int valueFunction(State state) {
        this.paintGraph(state);
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
        this.geneticStates = StateFactory.createForGenetic(4, 4, this.colors);
    }

    public State[] getRandomChilds(int k) {
        return StateFactory.createForGenetic(4, 4, this.colors);
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
        return true;
    }

    public int goalTest(double[] values) {
        for (int i = 0; i < values.length; i++)
            if (values[i] == 0)
                return i;
        return -1;
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        return 0;
    }
}
