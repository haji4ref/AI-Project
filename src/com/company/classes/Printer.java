package com.company.classes;

import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.utils.State;

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

    public static void print(Printable[] printables) {
        for (Printable printable : printables)
            printable.print();
    }

    public static void print(String[][] strings) {
        for (int i = 0; i < strings.length; i++) {
            for (int j = 0; j < strings[i].length; j++) {
                System.out.print(" " + strings[i][j]);
            }
            System.out.println();
        }
        System.out.println("------------");
    }

    public static void printLn(String string) {
        System.out.println(string);
    }


}
