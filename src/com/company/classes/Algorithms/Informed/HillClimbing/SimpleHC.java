package com.company.classes.Algorithms.Informed.HillClimbing;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.GreedyProblem;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

import java.util.LinkedList;
import java.util.ListIterator;

public class SimpleHC extends Algorithm {
    private GreedyProblem problem;

    public SimpleHC(GreedyProblem problem, State state) {
        super(problem, state);
        this.problem = problem;
        this.name = "SimpleHC";
    }

    @Override
    public Algorithm execute() {
        // Crate a queue for storing path
        Path path = new Path(new LinkedList<State>());

        path.add(this.start);

        State toBeExtended = this.start;

        while (true) {
            ListIterator<State> i = this.extend(toBeExtended).listIterator();
            State selectedState = toBeExtended;
            while (i.hasNext()) {
                State state = i.next();
                selectedState = this.problem.valueFunction(state) > selectedState.getSuitability()
                        ? state
                        : selectedState;
            }
            if (toBeExtended.equals(selectedState)) {
                return this;
            } else {
                path.add(selectedState);
                toBeExtended = selectedState;
            }

        }

    }
}
