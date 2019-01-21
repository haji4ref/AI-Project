package com.company;

import com.company.classes.Algorithms.*;
import com.company.classes.Algorithms.Informed.SimulatedAnealing;
import com.company.classes.Problems.*;
import com.company.classes.Problems.utils.State;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
//
//        Algorithm algorithm = new BFS(graph,startNode).setGraphSearch();
////        Algorithm algorithm = new IDS(graph, 0);
//
//        algorithm.execute();

        GreedyProblem problem = new SixthProblem();

        Algorithm algorithm = new SimulatedAnealing(problem, problem.getInitState());

        algorithm.execute().printStatus();

//        ArrayList<State> states = problem.successors(
//                new Action("ada"),
//                problem.getInitState()
//        );
//        printList(states.listIterator());
    }

    public static void printList(Iterator<State> list) {
        while (list.hasNext()) {
            list.next().printValues();
            System.out.println();
        }
    }
}
