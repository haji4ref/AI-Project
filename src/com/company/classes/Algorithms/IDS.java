package com.company.classes.Algorithms;

import com.company.classes.Graph;

public class IDS extends Algorithm {
    public IDS(Graph graph, int start) {
        super(graph, start);
    }

    @Override
    public void execute() {
        int i = 0;
        DLS dls = new DLS(this.graph, this.start, i);
        while (i < 4) {
            dls.execute();
            dls.setLimit(++i);
        }
    }
}
