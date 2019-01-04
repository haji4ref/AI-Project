package com.company.classes.Algorithms.Informed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

public class AStar extends Algorithm implements InformedInterface {
    public AStar(Problem problem, State state) {
        super(problem, state);

        this.name = "A*";
    }

    @Override
    public Algorithm execute() {
        return null;
    }

    @Override
    public int heuristic(State state) {
        return 0;
    }
}
