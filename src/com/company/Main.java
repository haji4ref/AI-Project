package com.company;

import com.company.classes.Algorithms.*;
import com.company.classes.Algorithms.Uniformed.BFS;
import com.company.classes.Graph;
import com.company.classes.MyNodeBuilder;
import com.company.classes.Node;
import com.company.classes.Problems.Action;
import com.company.classes.Problems.FirstProblem;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.State;

import java.lang.reflect.Array;
import java.util.ArrayList;
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

        Problem problem = new FirstProblem();

        Algorithm algorithm = new BFS(problem, problem.getInitState()).setGraphSearch();

        algorithm.execute();
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
