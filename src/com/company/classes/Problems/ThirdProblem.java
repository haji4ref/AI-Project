package com.company.classes.Problems;

import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.StateFactory;

import java.util.ArrayList;
import java.util.LinkedList;

public class ThirdProblem extends Problem {

    private int i, j;
    private int[][] blocksArray = new int[][]{{2, 1}, {3, 5}, {4, 3}, {5, 4}};
    private int[][] goalsArray = new int[][]{{6, 0}, {7, 4}};

    public ThirdProblem() {
        this.setInitState();
        this.setActions();
    }

    @Override
    protected void setInitState() {
        this.initState = new State(
                new String[]{
                        "0", "5"
                }
        );
        this.i = 0;
        this.j = 5;
    }

    @Override
    protected void setActions() {
        this.actions = new Action[]{
                new Action("MoveTL"),
                new Action("MoveTR"),
                new Action("MoveLT"),
                new Action("MoveRT"),
                new Action("MoveBL"),
                new Action("MoveBR"),
                new Action("MoveLB"),
                new Action("MoveLR")
        };
    }

    @Override
    public Action[] possibleActions(State state) {
        ArrayList<Action> actions = new ArrayList<>();
        int x = state.getInt(0), y = state.getInt(1);
        if (x > 1 && y > 0 && !this.exists(new int[]{x - 2, y - 1})) {
            actions.add(this.actions[0]);
        }
        if (x > 1 && y < 7 && !this.exists(new int[]{x - 2, y + 1})) {
            actions.add(this.actions[1]);
        }
        if (x > 0 && y > 1 && !this.exists(new int[]{x - 1, y - 2})) {
            actions.add(this.actions[2]);
        }
        if (x > 0 && y < 6 && !this.exists(new int[]{x - 1, y + 2})) {
            actions.add(this.actions[3]);
        }
        if (x < 6 && y > 0 && !this.exists(new int[]{x + 2, y - 1})) {
            actions.add(this.actions[4]);
        }
        if (x < 6 && y < 7 && !this.exists(new int[]{x + 2, y + 1})) {
            actions.add(this.actions[5]);
        }
        if (x < 7 && y > 1 && !this.exists(new int[]{x + 1, y - 2})) {
            actions.add(this.actions[6]);
        }
        if (x < 7 && y < 6 && !this.exists(new int[]{x + 1, y + 2})) {
            actions.add(this.actions[7]);
        }
        Action[] actionsArray = new Action[actions.size()];

        return actions.toArray(actionsArray);
    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        ArrayList<State> result = new ArrayList<State>();
        int x = state.getInt(0), y = state.getInt(1);
        if (action.getValue().equals(actions[0].getValue())) {// GO_TL
            x = x - 2;
            y = y - 1;
        } else if (action.getValue().equals(actions[1].getValue())) {// GO_TR
            x = x - 2;
            y = y + 1;
        } else if (action.getValue().equals(actions[2].getValue())) {// GO_LT
            x = x - 1;
            y = y - 2;
        } else if (action.getValue().equals(actions[3].getValue())) {// GO_RT
            x = x - 1;
            y = y + 2;
        } else if (action.getValue().equals(actions[4].getValue())) {// GO_BL
            x = x + 2;
            y = y - 1;
        } else if (action.getValue().equals(actions[5].getValue())) {// GO_BR
            x = x + 2;
            y = y + 1;
        } else if (action.getValue().equals(actions[6].getValue())) {// GO_LB
            x = x + 1;
            y = y - 2;
        } else if (action.getValue().equals(actions[7].getValue())) {// GO_RB
            x = x + 1;
            y = y + 2;
        }

        result.add(StateFactory.createPositionalState(x, y));

        return result;

    }

    @Override
    public boolean goalTest(State state) {
        return this.exists(this.toPosition(state), this.goalsArray);
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        return 0;
    }

    private boolean exists(int[] position, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] tmp = array[i];
            if (position[0] == tmp[0] && position[1] == tmp[1]) {
                return true;
            }
        }
        return false;
    }

    private boolean exists(int[] position) {
        return this.exists(position, this.blocksArray);
    }

    private void Move(String[][] array, int i1, int j1, int i2, int j2) {
        String tmp;
        tmp = array[i1][j1];
        array[i1][j1] = array[i2][j2];
        array[i2][j2] = tmp;
    }

    private int[] toPosition(State state) {
        return new int[]{state.getInt(0), state.getInt(1)};
    }

}


