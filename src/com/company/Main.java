package com.company;

import com.company.classes.Algorithms.*;
import com.company.classes.Algorithms.Informed.HillClimbing.RandomHC;
import com.company.classes.Algorithms.Informed.HillClimbing.SimpleHC;
import com.company.classes.Algorithms.Uniformed.*;
import com.company.classes.Problems.*;
import com.company.classes.Problems.utils.State;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
//        Graph graph = new Graph(9);
//
//        graph.addEdge(MyNodeBuilder.instance("0",1), MyNodeBuilder.instance("1",1));
//        graph.addEdge(MyNodeBuilder.instance("0",1), MyNodeBuilder.instance("2",1));
//        graph.addEdge(MyNodeBuilder.instance("0",1), MyNodeBuilder.instance("3",1));
//        graph.addEdge(MyNodeBuilder.instance("1",1), MyNodeBuilder.instance("4",1));
//        graph.addEdge(MyNodeBuilder.instance("1",1), MyNodeBuilder.instance("2",1));
//        graph.addEdge(MyNodeBuilder.instance("2",1), MyNodeBuilder.instance("5",1));
//        graph.addEdge(MyNodeBuilder.instance("3",1), MyNodeBuilder.instance("6",1));
//        graph.addEdge(MyNodeBuilder.instance("6",1), MyNodeBuilder.instance("7",1));
//        graph.addEdge(MyNodeBuilder.instance("7",1), MyNodeBuilder.instance("5",1));
//
//        Node startNode = MyNodeBuilder.instance("0",1);
//
//        Algorithm algorithm = new BFS(graph,startNode).setGraphSearch();
////        Algorithm algorithm = new IDS(graph, 0);
//
//        algorithm.execute();

        GreedyProblem problem = new FourthProblem(4);


        Algorithm algorithm = new RandomHC(problem, problem.getInitState());

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
