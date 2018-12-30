package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.utils.State;

public class IDS extends Algorithm {
    public IDS(Problem problem, State start) {
        super(problem, start);

        this.name = "IDS";
    }

    @Override
    public Algorithm execute() {
        int i = 0;
        DLS dls;
        do {
            dls = (DLS) new DLS(this.problem, this.start).setLimit(++i).setGraphSearch();
            dls.execute();
        } while (!dls.hasAnswer());

        dls.printStatus();

        this.hasAnswer = true;

        return this;
    }

    @Override
    public void printStatus() {
        System.out.println("IDS results includes searching iteratively by dls algorithm :");
    }
}
