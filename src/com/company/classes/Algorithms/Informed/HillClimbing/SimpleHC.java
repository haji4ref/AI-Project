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
        this.path = new Path(new LinkedList<State>());

        this.path.add(this.start);

        State toBeExtended = this.start;

        while (true) {
            ListIterator<State> i = this.extend(toBeExtended).listIterator();
            this.incrementExtendedNumber();
            State selectedState = toBeExtended;
            State state = toBeExtended;
            while (i.hasNext()) {
                selectedState = this.problem.valueFunction(state) > this.problem.valueFunction(selectedState)
                        ? state
                        : selectedState;
                this.incrementVisitedNumber();
                state = i.next();
            }
            if (toBeExtended.equals(selectedState)) {
                this.setMaxMemory(this.extend(toBeExtended).size());
                return this;
            } else {
                this.path.add(selectedState);
                toBeExtended = selectedState;
            }

        }

    }
}
