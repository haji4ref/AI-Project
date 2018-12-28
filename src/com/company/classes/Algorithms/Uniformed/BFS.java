package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Graph;
import com.company.classes.Node;
import com.company.classes.Problems.Action;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS extends Algorithm {
    public BFS(Problem problem, State state) {
        super(problem, state);
    }

    @Override
    public void execute() {
        // Mark all the vertices as not visited(By default
        // set as false)
        ArrayList<State> visited = new ArrayList<State>();

        // Create a queue for BFS
        LinkedList<State> queue = new LinkedList<State>();
        // Crate a queue for storing path
        LinkedList<Path> pathQueue = new LinkedList<Path>();

        // Mark the current node as visited and enqueue it
        visited.add(this.start);
        queue.add(this.start);
        LinkedList linkedList = new LinkedList<State>();
        linkedList.add(this.start);
        pathQueue.add(new Path(linkedList));

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            this.start = queue.poll();
            this.path = pathQueue.poll();

            if (problem.goalTest(this.path.last())) {
                this.prinPath();
                System.out.println("END");
                return;
            }

            // extend the current node
            ArrayList<State> stateArrayList = new ArrayList<State>();
            for (Action action : problem.possibleActions(this.start)) {
                stateArrayList.addAll(problem.successors(action, this.start));
            }
            ListIterator<State> i = stateArrayList.listIterator();
            this.incrementExtendedNumber();
            while (i.hasNext()) {
                // visit the node
                State state = i.next();
                this.incrementVisitedNumber();
                if (this.graphSearch && !visited.contains(state)) {
                    visited.add(state);
                    queue.add(state);
                    pathQueue.add(new Path(this.path).add(state));
                } else if (!this.graphSearch) {
                    queue.add(state);
                    pathQueue.add(new Path(this.path).add(state));
                }

                // compare current queue size to maxMemory
                this.setMaxMemory(queue.size());
            }
        }
    }
}
