package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class BFS extends Algorithm {
    public BFS(Problem problem, State state) {
        super(problem, state);
        this.name = "BFS";
    }

    @Override
    public Algorithm execute() {
        // Mark all the vertices as not visited(By default
        // set as false)
        ArrayList<String> visited = new ArrayList<String>();

        // Create a queue for BFS
        LinkedList<State> queue = new LinkedList<State>();
        // Crate a queue for storing path
        LinkedList<Path> pathQueue = new LinkedList<Path>();

        // Mark the current node as visited and enqueue it
        visited.add(this.start.joinValues());
        queue.add(this.start);
        LinkedList linkedList = new LinkedList<State>();
        linkedList.add(this.start);
        pathQueue.add(new Path(linkedList));

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            this.start = queue.poll();
            this.path = pathQueue.poll();

            if (this.problem.goalTest(this.path.last()))
                return this;

            // extend the current node
            ListIterator<State> i = this.extend(this.start).listIterator();
            this.incrementExtendedNumber();

            while (i.hasNext()) {
                // visit the node
                State state = i.next();
                if (this.graphSearch && !visited.contains(state.joinValues())) {
                    this.incrementVisitedNumber();
                    visited.add(state.joinValues());
                    queue.add(state);
                    pathQueue.add(new Path(this.path).add(state));
                } else if (!this.graphSearch) {
                    this.incrementVisitedNumber();
                    queue.add(state);
                    pathQueue.add(new Path(this.path).add(state));
                }

                // compare current queue size to maxMemory
                this.setMaxMemory(queue.size());
            }
        }
        return this;
    }
}
