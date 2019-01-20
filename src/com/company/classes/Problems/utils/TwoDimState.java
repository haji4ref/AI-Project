package com.company.classes.Problems.utils;

public class TwoDimState extends State {
    private int m = 3;
    private int n = 3;

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
        for (int i = 0; i < this.m; i++) {
            for (int j = 0; j < this.n; j++)
                System.out.print(this.value[i * this.m + j] + " ");
            System.out.println();
        }
        System.out.println("---------");
    }
}
