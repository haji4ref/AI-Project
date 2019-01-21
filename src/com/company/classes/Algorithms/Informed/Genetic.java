package com.company.classes.Algorithms.Informed;

import com.company.classes.Algorithms.Algorithm;
import com.company.classes.Printer;
import com.company.classes.Problems.SixthProblem;
import com.company.classes.Problems.utils.State;

import java.util.concurrent.ThreadLocalRandom;

public class Genetic extends Algorithm {
    private SixthProblem problem;
    private State[] initPop;
    private int k = 0;
    private boolean flag = true;
    private int steps = 0;
    private State goalState;

    public Genetic(SixthProblem problem, State state) {
        super(problem, state);
        this.problem = problem;
        this.k = this.problem.nodes;
        this.name = "GENETIC";
    }

    @Override
    public Algorithm execute() {
        State[] states;
        this.initPop = this.problem.getRandomChilds(this.k);
        while (true) {
            // calculate fitness Values : probs
            double[] fitnessValues = this.getFitnessValues(this.initPop);
            // check we are in goal or not
            int isGoal = this.problem.goalTest(fitnessValues);
            if (isGoal != -1) {
                this.goalState = this.initPop[isGoal];
                return this;
            }
            // selection
            State[] selectedStates = this.select(this.initPop, fitnessValues);
            // crossover
            State[] crossoveredStates = this.crossover(selectedStates);
            // mutation
            State[] mutatedStates = this.mutation(crossoveredStates);
            // pick k from states
            this.initPop = this.pick(mutatedStates);
            this.steps++;
        }

    }

    private State[] pick(State[] state) {
        State[] picked = new State[this.k];
        for (int i = 0; i < this.k; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, state.length);
            picked[i] = state[random];
        }
        return picked;
    }

    public void printStatus() {

        System.out.println(this.name+" result:");
        System.out.println("Steps: " + this.steps);
        System.out.println("GoalState: ");
        this.goalState.printValues();

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
        int counter = 0;
        for (int i = 0; i < states.length; i++) {
            for (int j = i + 1; j < states.length; j++) {
                result[counter++] = this.marry(states[i], states[j], states.length / 2);
                result[counter++] = this.marry(states[j], states[i], states.length / 2);
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

    private State[] select(State[] states, double[] probs) {
        int m_random = 0;
        State[] states1 = new State[states.length];
//        for (int i = 0; i < probs.length; i++)
//            System.out.print(probs[i] + ",");
//        System.out.println();
        for (int i = 0; i < states.length; i++) {
            int random = ThreadLocalRandom.current().nextInt(0, 100 + 1);
            m_random = random;

            double sum = 0;
            for (int j = 0; j < probs.length; j++) {
                sum += probs[j];
//                System.out.println(sum);
                if (random <= Math.ceil(sum)) {
                    states1[i] = states[j];
                    break;
                }
            }
        }
        return states1;
    }

    private double[] getFitnessValues(State[] states) {
        double[] values = new double[states.length];
        double sum = 0;
        for (int i = 0; i < states.length; i++) {
            values[i] = (double) this.problem.valueFunction(states[i]);
            sum += values[i];
        }
        if (sum > 0)
            for (int i = 0; i < states.length; i++) {
                values[i] = (values[i] / sum) * 100;
            }
        return values;
    }

}
