package com.company.classes.Problems.utils;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

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

    public static State[] createForGenetic(int strings, int num, String[] colors) {
        State[] states = new State[num];
        for (int i = 0; i < num; i++) {
            String[] strings1 = new String[strings];
            for (int j = 0; j < strings; j++) {
                int random = ThreadLocalRandom.current().nextInt(0, colors.length);
                strings1[j] = colors[random];
            }
            states[i] = new State(strings1);
        }
        return states;
    }
}
