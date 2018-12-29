package com.company.classes.Algorithms;

import com.company.classes.Printer;
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

    public void push(State state) {
        this.value.push(state);
    }

    public State pop() {
        return this.value.pop();
    }

    public int size() {
        return this.value.size();
    }

    public Iterator listIterator() {
        return this.value.listIterator();
    }

    public State last() {
        return this.value.getLast();
    }

    public boolean isEmpty() {
        return this.value.isEmpty();
    }

    public State get(int index) {
        return this.value.get(index);
    }

    public void printPath() {
        Printer.printStatesIterator(this.listIterator());
    }
}
