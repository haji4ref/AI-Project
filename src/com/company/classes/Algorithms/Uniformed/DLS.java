package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.ListIterator;

public class DLS extends Algorithm {
    private int limit = 0;

    public DLS(Problem problem, State start) {
        super(problem, start);

        this.name = "DLS";
    }

    public DLS setLimit(int limit) {
        this.limit = limit;

        return this;
    }

    @Override
    public Algorithm execute() {
        this.clearAnswer();

        ArrayList<String> visited = new ArrayList<String>();

        // Call the recursive helper function to print DFS traversal
        this.hasAnswer = DFSUtil(this.start, visited, 0);

        return this;
    }

    // A function used by DFS
    private boolean DFSUtil(State state, ArrayList<String> visited, int currentDepth) {
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
            if (this.limit > currentDepth) {
                if (this.graphSearch && !visited.contains(state1.joinValues())) {
                    this.incrementVisitedNumber();
                    if (DFSUtil(state1, visited, currentDepth + 1))
                        return true;
                    else
                        this.path.pop();
                } else if (!this.graphSearch) {
                    this.incrementVisitedNumber();
                    if (DFSUtil(state1, visited, currentDepth + 1))
                        return true;
                    else
                        this.path.pop();
                }
            }


            this.setMaxMemory(this.path.size());
        }
        return false;
    }

    @Override
    protected void printPath() {
        int counter = 0, size = this.path.size();
        while (counter < size) {
//            System.out.print(counter + ".");
            this.path.get(size - 1 - counter).printValues();
            counter++;
        }

    }
}
