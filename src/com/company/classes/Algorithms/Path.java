package com.company.classes.Algorithms;

import com.company.classes.Problems.State;

import java.util.Iterator;
import java.util.LinkedList;

public class Path {
    private LinkedList<State> value;

    public Path(LinkedList<State> value) {
        this.value = value;
    }

    public Path(Path path) {
        this.value = (LinkedList<State>) path.getValue().clone();
    }

    public void setValue(LinkedList<State> value) {
        this.value = value;
    }

    public LinkedList<State> getValue() {
        return value;
    }

    public Path add(State state) {
        this.value.add(state);
        return this;
    }

    public Iterator listIterator() {
        return this.value.listIterator();
    }

    public State last() {
        return this.value.getLast();
    }
}
