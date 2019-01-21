package com.company.classes.Algorithms.Informed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Problems.FifthProblem;
import com.company.classes.Problems.GreedyProblem;
import com.company.classes.Problems.SixthProblem;
import com.company.classes.Problems.utils.State;

import java.util.concurrent.ThreadLocalRandom;

public class Genetic extends Algorithm {
    private SixthProblem problem;
    private State[] initPop;
    private int k = 0;
    private boolean flag = true;

    public Genetic(SixthProblem problem, State state) {
        super(problem, state);
        this.problem = problem;
        this.k = this.problem.nodes;
    }

    @Override
    public Algorithm execute() {
        State[] states;
        this.initPop = this.problem.getRandomChilds(this.k);
        while (true) {
            // calculate fitness Values : probs
            int[] fitnessValues = this.getFitnessValues(this.initPop);
            // selection
            states = this.select(this.initPop, fitnessValues);
            // crossover
            states = this.crossover(states);
            // mutation
            states = this.mutation(states);
            // pick k from states
        }


        return this;
    }


    private State[] mutation(State[] states) {
        State[] result = new State[states.length];
        int random = ThreadLocalRandom.current().nextInt(0, 100);
        for (int i = 0; i < states.length; i++) {
            if ((2 * random + i) % 5 == 4) {
                states[i].setValue(ThreadLocalRandom.current().nextInt(
                        0, states[i].length()
                        ), this.problem.getRandomColor()
                );
            }
            result[i] = states[i];
        }
        return result;
    }

    private State[] crossover(State[] states) {
        State[] result = new State[(states.length * (states.length - 1))];
        for (int i = 0; i < states.length; i++) {
            for (int j = i + 1; j < states.length; j++) {
                result[i * states.length + j] = this.marry(states[i], states[j], states.length / 2);
            }
        }
        return result;
    }

    private State marry(State state1, State state2, int offset) {
        State state3 = new State(new String[state1.length()]);
        if (this.flag) {
            for (int i = 0; i < offset; i++) {
                state3.setValue(i, state1.getValue(i));
            }
            for (int i = offset; i < state2.length(); i++) {
                state3.setValue(i, state2.getValue(i));
            }
        }
        return state3;
    }

    private State[] select(State[] states, int[] probs) {

        State[] states1 = new State[states.length];
        for (int i = 0; i < states.length; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            int sum = 0;
            for (int j = 0; j < probs.length; j++) {
                if (random < sum) {
                    states1[i] = states[j];
                    break;
                } else {
                    sum += probs[j];
                }
            }
        }
        return states1;
    }

    private int[] getFitnessValues(State[] states) {
        int[] values = new int[states.length];
        int sum = 0;
        for (int i = 0; i < states.length; i++) {
            values[i] = this.problem.valueFunction(states[i]);
            sum += values[i];
        }
        for (int i = 0; i < states.length; i++) {
            values[i] = (values[i] / sum) * 100;
        }
        return values;
    }

}
