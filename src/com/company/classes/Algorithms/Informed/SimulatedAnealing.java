package com.company.classes.Algorithms.Informed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.GreedyProblem;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class SimulatedAnealing extends Algorithm {
    private GreedyProblem problem;

    private double T = 100;

    public SimulatedAnealing(GreedyProblem problem, State state) {
        super(problem, state);

        this.name = "SA";
        this.problem = problem;

    }

    @Override
    public Algorithm execute() {
        // Crate a queue for storing path
        this.path = new Path(new LinkedList<State>());

        this.path.add(this.start);

        State toBeExtended = this.start;

        while (true) {
            ArrayList<State> children = this.extend(toBeExtended);
            this.incrementExtendedNumber();
            // select random child
            int randomChild = ThreadLocalRandom.current().nextInt(0, children.size());
            State neighbour = children.get(randomChild);
            // pick a random number
            double randomDbl = ThreadLocalRandom.current().nextDouble(0, 1);
            if (this.calculateProb(toBeExtended, neighbour) > randomDbl) {
                toBeExtended = neighbour;
            }
            this.decreaseTemp("MIN");
            if (this.T < 0.001)
                return this;
        }

    }

    private double calculateProb(State current, State neighbour) {
        return Math.exp((this.problem.valueFunction(neighbour) - this.problem.valueFunction(current)) / this.T);
    }

    private void decreaseTemp(String operator) {
        switch (operator) {
            case "MIN":
                this.T -= 2;
                break;
            case "DIV":
                this.T /= 2;
                break;
        }
    }


}
