package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Graph;
import com.company.classes.Node;

public class IDS extends Algorithm {
    public IDS(Graph graph, Node start) {
        super(graph, start);
    }

    @Override
    public void execute() {
        int i = 0;
        DLS dls = new DLS(this.graph, this.start, i);
        while (i < 4) {
            dls.execute();
            dls.setLimit(++i);
            System.out.println();
        }
    }
}
