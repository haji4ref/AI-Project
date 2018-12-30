package com.company.classes.Problems;

import java.util.Arrays;

public class StateFactory {
    public static State create(String... strings) {
        return new State(strings);
    }

    public static State create(String string, int number) {
        String[] strings = new String[number];
        Arrays.fill(strings, string);
        return new State(strings);
    }
}
