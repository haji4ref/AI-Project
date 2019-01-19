package com.company.classes.Algorithms.Informed.HillClimbing;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Printer;
import com.company.classes.Problems.GreedyProblem;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.concurrent.ThreadLocalRandom;

public class RandomHC extends Algorithm {
    private GreedyProblem problem;

    public RandomHC(GreedyProblem problem, State state) {
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
            ArrayList<State> betterThanCurrent = new ArrayList<>();
            this.incrementExtendedNumber();
            State selectedState = toBeExtended;
            State state = toBeExtended;
            while (i.hasNext()) {
                if (this.problem.valueFunction(state) > this.problem.valueFunction(selectedState))
                    betterThanCurrent.add(state);
                this.incrementVisitedNumber();
                state = i.next();
            }
            selectedState = this.select(betterThanCurrent, toBeExtended);
            if (toBeExtended.equals(selectedState)) {
                this.setMaxMemory(this.extend(toBeExtended).size());
                return this;
            } else {
                this.path.add(selectedState);
                toBeExtended = selectedState;
            }

        }

    }

    private State select(ArrayList<State> arrayList, State current) {
        int sum = 0;
        // calculate total
        for (State state : arrayList)
            sum += state.getSuitability() - current.getSuitability();
        // sort array list
        arrayList.sort((a, b) -> Integer.compare(b.getSuitability(), a.getSuitability()));
        // make a random number : 0 < random < 100
        int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        int upperBound = 100;
        for (int i = 0; i < arrayList.size(); i++) {
            // calculate probability
            int prop = (int) Math.ceil(
                    (
                            (arrayList.get(i).getSuitability() - current.getSuitability())
                                    /
                                    (double) sum
                    ) * 100);
            // checks if random number is in most probable range
            if (upperBound - prop < random)
                return arrayList.get(i);
            // if not then check random number is in next most probable range
            upperBound -= prop;
        }
        // if all neighbours are lower than current return the current for next step
        return current;
    }
}
