package com.company.classes;

import com.company.classes.Problems.State;

import java.util.Iterator;

public class Printer {

    public static void printStatesIterator(Iterator<State> iterator) {
        while (iterator.hasNext())
            System.out.println(iterator.next().joinValues() + " ");
        System.out.println("------------");

    }
}
