package com.company.classes.Problems.utils;

public class TwoDimState extends State {
    public TwoDimState(String[] value) {
        super(value);
    }

    @Override
    public void printValues() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(this.value[i * 3 + j] + " ");
            System.out.println();
        }
        System.out.println("---------");
    }
}
