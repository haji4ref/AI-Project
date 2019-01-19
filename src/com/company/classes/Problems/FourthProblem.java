package com.company.classes.Problems;

import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.LinkedList;

public class FourthProblem extends GreedyProblem {
    private int K = 0;

    public FourthProblem(int k) {
        this.K = k;
    }

    @Override
    protected void setInitState() {

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

    @Override
    public int valueFunction(State state) {
        int sum = 0, max = 0;
        for (int i = 0; i < this.K; i++) {
            sum = state.getInt(i) + state.getInt(i + 1) + state.getInt(i + 1);
            max = sum > max ? sum : max;
        }
        state.setSuitability(max);
        return 100 - max;
    }
}
