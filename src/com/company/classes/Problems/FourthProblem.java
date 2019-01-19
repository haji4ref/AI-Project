package com.company.classes.Problems;

import com.company.classes.Printer;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.StateFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public class FourthProblem extends GreedyProblem {
    private int K = 0;

    public FourthProblem(int k) {
        this.K = k;
        this.setInitState();
        this.setActions();
    }

    @Override
    protected void setInitState() {
        String[] strings = new String[this.K * 3];
        for (int i = 0; i < this.K * 3; i++)
            strings[i] = Integer.toString(ThreadLocalRandom.current().nextInt(0, 10 + 1));
        this.initState = StateFactory.create(strings);
    }

    @Override
    protected void setActions() {
        this.actions = new Action[]{
                new Action("ORG")
        };
    }

    @Override
    public Action[] possibleActions(State state) {
        return this.actions;
    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        ArrayList<State> result = new ArrayList<State>();
        for (int i = 0; i < state.length(); i++) {
            for (int j = i + 1; j < state.length(); j++) {
                if (state.getInt(i) != state.getInt(j))
                    result.add(new State(state).swap(i, j));
            }
        }
        return result;
    }

    @Override
    public boolean goalTest(State state) {
        // nothing
        return true;
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        return 0;
    }

    @Override
    public int valueFunction(State state) {
        int sum = 0, max = 0;
        for (int i = 0; i < this.K; i++) {
            sum = state.getInt(i * 3) +
                    state.getInt(i * 3 + 1) +
                    state.getInt(i * 3 + 2);
            max = sum > max ? sum : max;
        }
        state.setSuitability(100 - max);
        return 100 - max;
    }
}
