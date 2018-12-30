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

    public Path removeLast() {
        this.value.pollLast();

        return this;
    }

    public Path rotate() {
        LinkedList<State> rotatedValue = new LinkedList<State>();
        int index = 0, size = this.value.size();
        while (index < size)
            rotatedValue.add(index, this.value.get(size - (++index)));

        this.setValue(rotatedValue);

        return this;
    }

    public Path concat(Path path) {
        int counter = 0, size = path.size();
        while (counter < size)
            this.value.add(path.get(counter++));
        return this;
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
        Printer.print(this.listIterator());
    }
}
