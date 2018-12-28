package com.company.classes.Problems;


public class State {
    private String[] value;

    public State(String[] value) {
        this.value = value;
    }

    public State(State state) {
        this.value = state.getValue().clone();
    }

    public int length() {
        return this.value.length;
    }

    public String getValue(int index) {
        return this.value[index];
    }

    public String[] getValue() {
        return this.value;
    }

    public State setValue(int index, String value) {
        this.value[index] = value;

        return this;
    }

    public void printValues() {
        for (String value : this.value) {
            System.out.print(value + " ");
        }
    }
}