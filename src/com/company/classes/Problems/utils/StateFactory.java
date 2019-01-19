package com.company.classes.Problems.utils;

import java.util.Arrays;

public class StateFactory {
    public static State create(String... strings) {
        return new State(strings);
    }

    public static State create(int type, String... strings) {
        if (type == 1)
            return new TwoDimState(strings);
        return new State(strings);
    }

    public static State create(String string, int number) {
        String[] strings = new String[number];
        Arrays.fill(strings, string);
        return new State(strings);
    }

    public static State createPositionalState(int... values) {
        return new State(
                new String[]{
                        Integer.toString(values[0]), Integer.toString(values[1])
                }
        );
    }
}
