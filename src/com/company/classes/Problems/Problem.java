package com.company.classes.Problems;

import com.company.classes.Graph;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.LinkedList;

abstract public class Problem {
    protected State initState;

    protected State[] geneticStates;

    protected Action[] actions;

    protected Graph stateSpace;

    protected State finalState;

    public State getInitState() {
        return this.initState;
    }

    public State getFinalState() {
        return finalState;
    }

    abstract protected void setInitState();

    abstract protected void setActions();

    abstract public Action[] possibleActions(State state);

    abstract public ArrayList<State> successors(Action action, State state);

    abstract public boolean goalTest(State state);

    abstract public int pathCost(LinkedList<State> stateLinkedList);

}
