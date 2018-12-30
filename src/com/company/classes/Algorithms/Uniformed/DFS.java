package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.ListIterator;

public class DFS extends Algorithm {
    public DFS(Problem problem, State start) {
        super(problem, start);

        this.name = "DFS";
    }

    @Override
    public Algorithm execute() {
        clearAnswer();

        ArrayList<String> visited = new ArrayList<String>();

        // Call the recursive helper function to print DFS traversal
        this.hasAnswer = DFSUtil(this.start, visited);

        return this;
    }

    // A function used by DFS
    private boolean DFSUtil(State state, ArrayList<String> visited) {
        // Mark the current node as visited and print it
        visited.add(state.joinValues());

        this.path.push(state);

        if (this.problem.goalTest(state)) {
            return true;
        }

        // Recur for all the vertices adjacent to this vertex
        // extend the current node
        ListIterator<State> iterator = this.extend(state).listIterator();
        this.incrementExtendedNumber();
        while (iterator.hasNext()) {
            State state1 = iterator.next();
            if (this.graphSearch && !visited.contains(state1.joinValues())) {
                this.incrementVisitedNumber();
                if (DFSUtil(state1, visited))
                    return true;
                else
                    this.path.pop();
            } else if (!this.graphSearch) {
                this.incrementVisitedNumber();
                if (DFSUtil(state1, visited))
                    return true;
                else
                    this.path.pop();
            }

            this.setMaxMemory(this.path.size());
        }
        return false;
    }

    @Override
    protected void printPath() {
        int counter = 0, size = this.path.size();
        while (counter < size) {
            System.out.print(counter + ".");
            this.path.get(size - 1 - counter).printValues();
            counter++;
        }

    }
}
