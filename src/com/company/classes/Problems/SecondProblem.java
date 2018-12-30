package com.company.classes.Problems;

import com.company.classes.Printer;
import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.StateFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class SecondProblem extends Problem {
    private String[][] twoDimState;

    private int emptyLocation;

    private State[] goalStates;


    public SecondProblem() {
        this.setInitState();
        this.setActions();
        this.setEmptyLocation(this.initState);
        this.goalStates = new State[]{
                StateFactory.create(1, "1", "2", "3", "4", "5", "6", "7", "8", "E"),
                StateFactory.create(1, "1", "4", "7", "2", "5", "8", "3", "6", "E"),
                StateFactory.create(1, "3", "2", "1", "6", "5", "4", "E", "8", "7"),
                StateFactory.create(1, "7", "4", "1", "8", "5", "2", "E", "6", "3"),
                StateFactory.create(1, "E", "6", "3", "8", "5", "2", "7", "4", "1"),
                StateFactory.create(1, "E", "8", "7", "6", "5", "4", "3", "2", "1"),
                StateFactory.create(1, "7", "8", "E", "4", "5", "6", "1", "2", "3"),
                StateFactory.create(1, "3", "6", "E", "2", "5", "8", "1", "4", "7"),
        };

//        this.castTwoDimState(this.initState);
//        this.printTwoDim();
//        Printer.print(this.successors(new Action("GO_TOP"), this.initState).listIterator());
//        Printer.print(this.possibleActions(this.initState));
    }

    @Override
    protected void setInitState() {
        this.initState = StateFactory.create(1, "5", "2", "7", "8", "4", "E", "1", "3", "6");
    }

    @Override
    protected void setActions() {
        this.actions = new Action[]{
                new Action("GO_TOP"),
                new Action("GO_BOTTOM"),
                new Action("GO_RIGHT"),
                new Action("GO_LEFT")
        };
    }

    @Override
    public Action[] possibleActions(State state) {
        this.setEmptyLocation(state);
        ArrayList<Action> result = new ArrayList<Action>();
        int i = this.emptyLocation / 3;
        int j = this.emptyLocation % 3;
        if (i > 0)
            result.add(this.actions[0]);
        if (i < 2)
            result.add(this.actions[1]);
        if (j < 2)
            result.add(this.actions[2]);
        if (j > 0)
            result.add(this.actions[3]);
        Action[] actions = new Action[result.size()];
        return result.toArray(actions);
    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        ArrayList<State> states = new ArrayList<>();
        this.twoDimState = this.castTwoDimState(state);
        this.setEmptyLocation(state);
        int iEmpty = this.emptyLocation / 3;
        int jEmpty = this.emptyLocation % 3;

        if (action.getValue().equals(actions[0].getValue())) {// GO_TOP
            swap(this.twoDimState, iEmpty, jEmpty, iEmpty - 1, jEmpty);
        } else if (action.getValue().equals(actions[1].getValue())) {// GO_BOTTOM
            swap(this.twoDimState, iEmpty, jEmpty, iEmpty + 1, jEmpty);
        } else if (action.getValue().equals(actions[2].getValue())) {// GO_RIGHT
            swap(this.twoDimState, iEmpty, jEmpty, iEmpty, jEmpty + 1);
        } else if (action.getValue().equals(actions[3].getValue())) {// GO_LEFT
            swap(this.twoDimState, iEmpty, jEmpty, iEmpty, jEmpty - 1);
        }

        states.add(this.castOnDimState(this.twoDimState));

        return states;

    }

    @Override
    public boolean goalTest(State state) {
        for (State state1 : this.goalStates)
            if (state.equals(state1))
                return true;
        return false;
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        int cost = 0;
        Iterator<State> stateIterator = stateLinkedList.listIterator();
        while (stateIterator.hasNext())
            cost += stateIterator.next().getCost();
        return cost;
    }

    private String[][] castTwoDimState(State state) {
        String[][] tmp = new String[3][3];

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp[i][j] = state.getValue((i * 3) + j);

        return tmp;
    }

    private State castOnDimState(String[][] strings) {
        String[] tmp = new String[9];
        int counter = 0;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                tmp[counter++] = strings[i][j];

        return StateFactory.create(1,tmp);
    }

    public void printTwoDim() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                System.out.print(this.twoDimState[i][j] + " ");
            System.out.println();
        }
    }

    private void setEmptyLocation(State state) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (state.getValue((i * 3) + j).equals("E")) {
                    this.emptyLocation = (i * 3) + j;
                    return;
                }
    }

    private void swap(String[][] array, int i1, int j1, int i2, int j2) {
        String tmp;
        tmp = array[i1][j1];
        array[i1][j1] = array[i2][j2];
        array[i2][j2] = tmp;
    }
}
