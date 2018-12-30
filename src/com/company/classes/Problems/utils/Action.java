package com.company.classes.Problems.utils;

import com.company.classes.Printable;

public class Action implements Printable {
    private String value;

    public Action(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    @Override
    public void print() {
        System.out.print(this.value + " ");
    }
}
