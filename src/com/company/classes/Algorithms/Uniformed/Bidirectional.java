package com.company.classes.Algorithms.Uniformed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Algorithms.Path;
import com.company.classes.Problems.Problem;
import com.company.classes.Problems.State;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;


public class Bidirectional extends Algorithm {
    LinkedList<State> forwardQueue, backwardQueue;
    ArrayList<String> forwardVisited, backwardVisited;
    LinkedList<Path> forwardPathQueue, backwardPathQueue;
    State areTheSame;
    private int areTheSameIndex;

    public Bidirectional(Problem problem, State state) {
        super(problem, state);

        this.name = "BIDIRECTIONAL";

        this.forwardQueue = new LinkedList<State>();
        this.backwardQueue = new LinkedList<State>();

        this.forwardVisited = new ArrayList<String>();
        this.backwardVisited = new ArrayList<String>();

        this.forwardPathQueue = new LinkedList<Path>();
        this.backwardPathQueue = new LinkedList<Path>();

    }

    @Override
    public Algorithm execute() {
        this.forwardQueue.add(this.problem.getInitState());
        this.backwardQueue.add(this.problem.getFinalState());

        this.forwardVisited.add(this.problem.getInitState().joinValues());
        this.backwardVisited.add(this.problem.getFinalState().joinValues());

        this.forwardPathQueue.add(this.pathStart(this.problem.getInitState()));
        this.backwardPathQueue.add(this.pathStart(this.problem.getFinalState()));

        while (!this.forwardQueue.isEmpty() && !this.backwardQueue.isEmpty()) {
            // forward side algorithm
            if (!this.forwardQueue.isEmpty()) {
                Path path1 = forwardPathQueue.poll();
                State state = this.forwardQueue.poll();

                // check that we arrived to target or the current state is in the queue of the other side algorithm
                if (state.joinValues().equals(this.problem.getFinalState().joinValues())
                        || this.contains(this.backwardQueue, state)) {

                    // then the current state is in both algorithm's queue
                    // just try to make path
                    this.path = path1.concat(
                            this.backwardPathQueue
                                    .get(this.areTheSameIndex)
                                    .removeLast()
                                    .rotate()
                    );
                    this.hasAnswer = true;
                    return this;
                }
                // else extend and continue like bfs that is implemented
                Iterator<State> iterator = this.extend(state).listIterator();
                this.incrementExtendedNumber();
                while (iterator.hasNext()) {
                    State state1 = iterator.next();
                    if (this.graphSearch && !this.forwardVisited.contains(state1.joinValues())) {
                        this.incrementVisitedNumber();
                        this.forwardVisited.add(state1.joinValues());
                        this.forwardQueue.add(state1);
                        this.forwardPathQueue.add(new Path(path1).add(state1));
                    } else if (!this.graphSearch) {
                        this.incrementVisitedNumber();
                        this.forwardQueue.add(state1);
                        this.forwardPathQueue.add(new Path(path1).add(state1));
                    }
                }
            }
            // backward side algorithm works like forward
            if (!this.backwardQueue.isEmpty()) {
                State state = this.backwardQueue.poll();
                Path path1 = backwardPathQueue.poll();

                if (state.joinValues().equals(this.problem.getInitState().joinValues())
                        || this.contains(this.forwardQueue, state)) {
                    this.path = path1.concat(
                            this.forwardPathQueue
                                    .get(this.areTheSameIndex)
                                    .removeLast()
                                    .rotate()
                    );
                    this.hasAnswer = true;
                    return this;
                }
                Iterator<State> iterator = this.extend(state).listIterator();
                this.incrementExtendedNumber();
                while (iterator.hasNext()) {
                    State state1 = iterator.next();
                    if (this.graphSearch && !this.backwardVisited.contains(state1.joinValues())) {
                        this.incrementVisitedNumber();
                        this.backwardVisited.add(state1.joinValues());
                        this.backwardQueue.add(state1);
                        this.backwardPathQueue.add(new Path(path1).add(state1));
                    } else if (!this.graphSearch) {
                        this.incrementVisitedNumber();
                        this.backwardQueue.add(state1);
                        this.backwardPathQueue.add(new Path(path1).add(state1));
                    }
                }
            }
            // set time complexity
            this.setMaxMemory(this.forwardQueue.size() + this.backwardQueue.size());
        }

        return this;
    }

    private boolean contains(LinkedList<State> queue, State state) {
        String value = state.joinValues();
        Iterator<State> iterator = queue.listIterator();
        int index = 0;
        while (iterator.hasNext()) {
            if (iterator.next().joinValues().equals(value)) {
                this.areTheSame = state;
                this.areTheSameIndex = index;
                return true;
            }
            index++;
        }
        return false;
    }

}
