package com.company.classes.Problems.utils;

import com.company.classes.Printer;

public class TwoDimState extends State {
    private int m = 3;
    private int n = 3;

    private Action calledAction = null;

    public TwoDimState(String[] value) {
        super(value);
    }

    public TwoDimState(String[] value, int m, int n) {
        super(value);
        this.m = m;
        this.n = n;
    }

    @Override
    public void printValues() {
        if (this.calledAction != null)
            Printer.printLn("Action " + this.calledAction.getValue());
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++)
                System.out.print(this.value[i * this.n + j] + " ");
            System.out.println();
        }
        if (this.calledAction != null)
            Printer.printLn("Suit: " + this.getSuitability());
        System.out.println("---------");
    }

    public TwoDimState setCalledAction(Action calledAction) {
        this.calledAction = calledAction;
        return this;
    }

    public Action getCalledAction() {
        return this.calledAction;
    }


}
