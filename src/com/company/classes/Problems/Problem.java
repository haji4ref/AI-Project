package com.company.classes.Problems;

import com.company.classes.Graph;

import java.lang.reflect.Array;
import java.util.ArrayList;

abstract public class Problem {
    protected State initState;

    protected Action[] actions;

    protected Graph stateSpace;

    public State getInitState() {
        return this.initState;
    }

    abstract protected void setInitState();

    abstract protected void setActions();

    abstract public Action[] possibleActions(State state);

    abstract public ArrayList<State> successors(Action action, State state);

}
