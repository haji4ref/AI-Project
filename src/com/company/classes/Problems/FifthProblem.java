package com.company.classes.Problems;

import com.company.classes.Problems.utils.Action;
import com.company.classes.Problems.utils.State;
import com.company.classes.Problems.utils.TwoDimState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FifthProblem extends GreedyProblem {
    @Override
    protected void setInitState() {
        this.initState = new TwoDimState(
                new String[]{
                        "o", "o", "o", "g", "g", "o", "o", "w", "o",
                        "g", "o", "o", "g", "g", "g", "g", "g", "g",
                        "w", "w", "w", "w", "w", "w", "r", "o", "w",
                        "b", "b", "r", "y", "b", "b", "y", "b", "b",
                        "r", "r", "b", "r", "r", "r", "w", "r", "r",
                        "y", "y", "y", "b", "y", "y", "b", "y", "y",

                }
                , 9, 6);
    }

    @Override
    protected void setActions() {
        this.actions = new Action[]{
                new Action("FRONT_RIGHT"),
                new Action("FRONT_LEFT"),
                new Action("BACK_RIGHT"),
                new Action("BACK_LEFT"),
                new Action("RIGHT_RIGHT"),
                new Action("RIGHT_LEFT"),
                new Action("LEFT_RIGHT"),
                new Action("LEFT_LEFT"),
                new Action("TOP_RIGHT"),
                new Action("TOP_LEFT"),
                new Action("BOT_RIGHT"),
                new Action("BOT_LEFT"),
        };
    }

    @Override
    public Action[] possibleActions(State state) {
        return this.actions;
    }

    @Override
    public ArrayList<State> successors(Action action, State state) {
        String[][] strings = this.castToTwo(state.getValue());

        if (action.equals(this.actions[0])) {//FRONT_RIGHT
            // shift
            String[] tmp = new String[]{strings[0][6], strings[0][7], strings[0][8]};
            this.shiftClock(strings, 1, 0, 'R', 'B');
            this.shiftClock(strings, 4, 1, 'T', 'R');
            this.shiftClock(strings, 3, 4, 'L', 'T');
            strings[3][0] = tmp[0];
            strings[3][3] = tmp[1];
            strings[3][6] = tmp[2];
            // rotate
            this.rotate(strings[2], true);
        } else if (action.equals(this.actions[1])) {//FRONT_LEFT
            // shift
            String[] tmp = new String[]{strings[0][6], strings[0][7], strings[0][8]};
            this.shiftClock(strings, 3, 0, 'L', 'B');
            this.shiftClock(strings, 4, 3, 'T', 'L');
            this.shiftClock(strings, 1, 4, 'R', 'T');
            strings[1][2] = tmp[2];
            strings[1][5] = tmp[1];
            strings[1][8] = tmp[0];
            // rotate
            this.rotate(strings[2], false);
        } else if (action.equals(this.actions[2])) {// BACK_RIGHT
            // shift
            String[] tmp = new String[]{strings[0][0], strings[0][1], strings[0][2]};
            strings[0][0] = strings[1][6];
            strings[0][1] = strings[1][3];
            strings[0][2] = strings[1][0];

            strings[1][0] = strings[4][6];
            strings[1][3] = strings[4][7];
            strings[1][6] = strings[4][8];

            strings[4][6] = strings[3][8];
            strings[4][7] = strings[3][5];
            strings[4][8] = strings[3][2];

            strings[3][2] = tmp[0];
            strings[3][5] = tmp[1];
            strings[3][8] = tmp[2];
            // rotate
            this.rotate(strings[5], true);
        } else if (action.equals(this.actions[3])) {// BACK_LEFT
            // shift
            String[] tmp = new String[]{strings[0][0], strings[0][1], strings[0][2]};
            strings[0][0] = strings[3][2];
            strings[0][1] = strings[3][5];
            strings[0][2] = strings[3][8];

            strings[3][2] = strings[4][8];
            strings[3][5] = strings[4][7];
            strings[3][8] = strings[4][6];

            strings[4][6] = strings[1][0];
            strings[4][7] = strings[1][3];
            strings[4][8] = strings[1][6];

            strings[1][0] = tmp[2];
            strings[1][3] = tmp[1];
            strings[1][6] = tmp[0];
            // rotate
            this.rotate(strings[5], false);
        } else if (action.equals(this.actions[4])) { // RIGHT_RIGHT
            // shift
            String[] tmp = new String[]{strings[0][2], strings[0][5], strings[0][8]};
            strings[0][2] = strings[2][2];
            strings[0][5] = strings[2][5];
            strings[0][8] = strings[2][8];

            strings[2][2] = strings[4][2];
            strings[2][5] = strings[4][5];
            strings[2][8] = strings[4][8];

            strings[4][2] = strings[5][2];
            strings[4][5] = strings[5][5];
            strings[4][8] = strings[5][8];

            strings[5][2] = tmp[2];
            strings[5][5] = tmp[1];
            strings[5][8] = tmp[0];
            // rotate
            this.rotate(strings[3], true);
        } else if (action.equals(this.actions[5])) {// RIGHT_LEFT
            // shift
            String[] tmp = new String[]{strings[0][2], strings[0][5], strings[0][8]};
            strings[0][2] = strings[5][8];
            strings[0][5] = strings[5][5];
            strings[0][8] = strings[5][2];

            strings[5][2] = strings[4][2];
            strings[5][5] = strings[4][5];
            strings[5][8] = strings[4][8];

            strings[4][2] = strings[2][2];
            strings[4][5] = strings[2][5];
            strings[4][8] = strings[2][8];

            strings[2][2] = tmp[0];
            strings[2][5] = tmp[1];
            strings[2][8] = tmp[2];
            // rotate
            this.rotate(strings[3], false);
        } else if (action.equals(this.actions[6])) {// LEFT_RIGHT
            // shift
            String[] tmp = new String[]{strings[0][0], strings[0][3], strings[0][6]};
            strings[0][0] = strings[2][0];
            strings[0][3] = strings[2][3];
            strings[0][6] = strings[2][6];

            strings[2][0] = strings[4][0];
            strings[2][3] = strings[4][3];
            strings[2][6] = strings[4][6];

            strings[4][0] = strings[5][0];
            strings[4][3] = strings[5][3];
            strings[4][6] = strings[5][6];

            strings[5][0] = tmp[2];
            strings[5][3] = tmp[1];
            strings[5][6] = tmp[0];
            // rotate
            this.rotate(strings[1], true);
        } else if (action.equals(this.actions[7])) {// LEFT_LEFT
            // shift
            String[] tmp = new String[]{strings[0][0], strings[0][3], strings[0][6]};
            strings[0][0] = strings[5][6];
            strings[0][3] = strings[5][3];
            strings[0][6] = strings[5][0];

            strings[5][0] = strings[4][0];
            strings[5][3] = strings[4][3];
            strings[5][6] = strings[4][6];

            strings[4][0] = strings[2][0];
            strings[4][3] = strings[2][3];
            strings[4][6] = strings[2][6];

            strings[2][0] = tmp[0];
            strings[2][3] = tmp[1];
            strings[2][6] = tmp[2];
            // rotate
            this.rotate(strings[1], true);
        } else if (action.equals(this.actions[8])) {// TOP_RIGHT
            // shift
            String[] tmp = copyRow(strings, 1);
            swapHorizontal(strings, 5, 1, false, 0);
            swapHorizontal(strings, 3, 5, true, 0);
            swapHorizontal(strings, 2, 3, false, 0);
            setRow(strings, tmp, 2, false);
            // rotate
            this.rotate(strings[0], true);
        } else if (action.equals(this.actions[9])) {// TOP_LEFT
            // shift
            String[] tmp = copyRow(strings, 2);
            swapHorizontal(strings, 3, 2, false, 0);
            swapHorizontal(strings, 5, 3, true, 0);
            swapHorizontal(strings, 1, 5, false, 0);
            setRow(strings, tmp, 1, false);
            // rotate
            this.rotate(strings[0], false);
        } else if (action.equals(this.actions[10])) {// BOT_RIGHT
            // shift
            String[] tmp = copyRow(strings, 1);
            swapHorizontal(strings, 5, 1, false, 6);
            swapHorizontal(strings, 3, 5, true, 6);
            swapHorizontal(strings, 2, 3, false, 6);
            setRow(strings, tmp, 2, false);
            // rotate
            this.rotate(strings[4], true);
        } else { // BOT_LEFT
            // shift
            String[] tmp = copyRow(strings, 2);
            swapHorizontal(strings, 3, 2, false, 6);
            swapHorizontal(strings, 5, 3, true, 6);
            swapHorizontal(strings, 1, 5, false, 6);
            setRow(strings, tmp, 1, false);
            // rotate
            this.rotate(strings[4], false);
        }
        ArrayList<State> states = new ArrayList<>();

        states.add(new State(this.castToOne(strings)));

        return states;

    }

    @Override
    public boolean goalTest(State state) {
        return false;
    }

    @Override
    public int pathCost(LinkedList<State> stateLinkedList) {
        return 0;
    }

    public String[] copyRow(String[][] twoDimStrings, int number) {
        return new String[]{twoDimStrings[number][0], twoDimStrings[number][1], twoDimStrings[number][2]};
    }

    public String[][] castToTwo(String[] strings) {
        String[][] strings1 = new String[6][9];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3 * 3; j++)
                strings1[i][j] = strings[i * 9 + j];
        }
        return strings1;
    }

    public String[] castToOne(String[][] strings) {
        String[] strings1 = new String[54];
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3 * 3; j++)
                strings1[i * 9 + j] = strings[i][j];
        }
        return strings1;
    }

    private void swapHorizontal(String[][] strings, int swaper, int swaped, boolean reverse, int offset) {
        if (reverse) {
            strings[swaped][0 + offset] = strings[swaper][2 + offset];
            strings[swaped][1 + offset] = strings[swaper][1 + offset];
            strings[swaped][2 + offset] = strings[swaper][0 + offset];
        }
        strings[swaped][0 + offset] = strings[swaper][0 + offset];
        strings[swaped][1 + offset] = strings[swaper][1 + offset];
        strings[swaped][2 + offset] = strings[swaper][2 + offset];
    }

    public void shiftClock(String[][] strings, int swaper, int swaped, char swaperEdge, char swapedEdge) {
        int[] swaperIndices = this.getIndices(swaperEdge);
        int[] swapedIndices = this.getIndices(swapedEdge);

        for (int i = 0; i < 3; i++)
            strings[swaped][swapedIndices[i]] = strings[swaper][swaperIndices[i]];

    }

    private int[] getIndices(char edge) {
        switch (edge) {
            case 'T':
                return new int[]{2, 1, 0};
            case 'B':
                return new int[]{6, 7, 8};
            case 'L':
                return new int[]{0, 3, 6};
            case 'R':
                return new int[]{8, 5, 2};
            default:
                return new int[]{};
        }
    }

    private void setRow(String[][] strings, String[] row, int rowNumber, boolean reverse) {
        if (reverse) {
            for (int i = 0; i < row.length; i++) {
                String tmp = row[i];
                row[i] = row[row.length - i];
                row[row.length - i] = tmp;
            }
        }
        strings[rowNumber] = row;
    }


    private void rotate(String[] strings, boolean clockwise) {
        String tmp = "";
        // calculate taranahade
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // swap
                tmp = strings[3 * i + j];
                strings[3 * i + j] = strings[3 * j + i];
                strings[3 * j + i] = tmp;
            }
        }
        // mirror
        if (clockwise) {
            for (int i = 0; i < 3; i++) {
                tmp = strings[3 * i];
                strings[3 * i] = strings[3 * i + 2];
                strings[3 * i + 2] = tmp;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                tmp = strings[i];
                strings[i] = strings[3 * 2 + i];
                strings[3 * 2 + i] = tmp;
            }
        }

    }

    @Override
    public int valueFunction(State state) {
        String[][] sides = this.castToTwo(state.getValue());
        HashMap<String, Integer> numberOfColors = new HashMap<String, Integer>() {
            {
                put("w", 0);
                put("b", 0);
                put("r", 0);
                put("g", 0);
                put("o", 0);
                put("y", 0);
            }
        };
        int sum = 0;
        for (int i = 0; i < sides.length; i++) {
            for (int j = 0; j < sides[i].length; j++) {
                numberOfColors.put(sides[i][j], numberOfColors.get(sides[i][j]) + 1);
            }
            sum += this.calculateMax((Integer[]) numberOfColors.values().toArray());
        }
        return sum;
    }

    private int calculateMax(Integer[] integers) {
        int max = 0;
        for (int i = 0; i < integers.length; i++) {
            max = max > integers[i] ? max : integers[i];
        }
        return max;
    }


}
