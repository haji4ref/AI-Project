package com.company.classes.Problems;

import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class FirstProblem extends Problem {

    // STATE OF FIRST PROBLEM
    // ['agent_location','man1_location','woman1_location','man2_location','woman2_location']
    // 'left','right'
    public FirstProblem() {
        this.setInitState();
        this.setActions();
        this.finalState = new State(new String[]{"right", "right", "right", "right", "right"});
    }

    @Override
    protected void setInitState() {
        this.initState = new State(new String[]{"left", "left", "left", "left", "left"});
    }

    @Override
    protected void setActions() {
        this.actions = new Action[]{new Action("GO_TO_RIGHT"), new Action("GO_TO_LEFT")};
    }

    @Override
    public Action[] possibleActions(State state) {
        if (state.getValue(0).equals("left"))
            return new Action[]{this.actions[0]};
        else
            return new Action[]{this.actions[1]};

    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        int passengers = 1;
        ArrayList<State> result = new ArrayList<State>();
        while (passengers <= 2) {
            for (int i = 1; i < state.length(); i++) {
                State state1 = null;
                // check if agent_location and human location are the same
                if (state.getValue(0).equals(state.getValue(i))) {
                    // if passengers number is more than 1 then agent can pick another human
                    if (passengers > 1) {
                        int[] possiblePairs = this.possiblePairsIndex(i);
                        for (int j = 0; j < possiblePairs.length; j++) {
                            if (state.getValue(i).equals(state.getValue(possiblePairs[j]))) {
                                // change selected
                                state1 = this.changeLocation(state, i);
                                // change pair of selected human
                                state1 = this.changeLocation(state1, possiblePairs[j]);
                                // change current location of agent then add the state to result
                                state1 = this.changeLocation(state1, 0);
                                result.add(state1);
                            }
                        }
                    } else {
                        state1 = this.changeLocation(state, i);
                        state1 = this.changeLocation(state1, 0);
                        result.add(state1);

                    }
                }

            }
            passengers++;
        }
        return result;


    }


    @Override
    public boolean goalTest(State state) {
        return Arrays.equals(state.getValue(), this.finalState.getValue());
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        int cost = 0;
        Iterator<State> stateIterator = stateLinkedList.listIterator();
        while (stateIterator.hasNext())
            cost += stateIterator.next().getCost();
        return cost;
    }

    private int[] possiblePairsIndex(int index) {
        if (index == 1 || index == 4) {
            return new int[]{2, 3};
        } else {
            return new int[]{1, 4};
        }
    }

    private State changeLocation(State state, int index) {
        if (state.getValue(0).equals("left"))
            return new State(state).setValue(index, "right");
        else
            return new State(state).setValue(index, "left");
    }

}
