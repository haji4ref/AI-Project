package com.company.classes;

import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.State;

import java.util.ArrayList;
import java.util.Iterator;

public class Printer {

    public static void print(Iterator<State> iterator) {
        while (iterator.hasNext())
            System.out.println(iterator.next().joinValues() + " ");
        System.out.println("------------");

    }

    public static void printPath(Iterator<Path> iterator) {
        while (iterator.hasNext())
            iterator.next().printPath();
        System.out.println("------------");

    }

    public static void print(ArrayList<String> arrayList) {
        int counter = 0;
        while (counter < arrayList.size())
            System.out.println(arrayList.get(counter++) + " ");
        System.out.println("------------");
    }


}
