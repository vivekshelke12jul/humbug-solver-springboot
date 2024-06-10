package com.vivek12jul.humbugSolver.node.state;

import com.vivek12jul.humbugSolver.node.state.action.Action;
import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

public class State {
    private int rows;
    private int columns;

    // in future we can use ArrayDeque<ArrayDeque<Tile>>, Where Tile will be another class,
    // class BlankTile inherits from Tile,
    // class bugTile inherits from Tile,
    // class StartTile inherits from Tile,
    // class Unreachable inherits from Tile
    // or simply use a Tile enum
    private ArrayDeque<ArrayDeque<Character>> grid;
    private HashSet<Bug> bugs;

    public State(){}

    public State(int rows, int columns, ArrayDeque<ArrayDeque<Character>> grid, HashSet<Bug> bugs) {
        this.rows = rows;
        this.columns = columns;
        this.grid = grid;
        this.bugs = bugs;
    }

    // Copy constructor
    private State(State state){
        this.rows = state.getRows();
        this.columns = state.getColumns();
        this.grid = state.getGrid();
        this.bugs = state.getBugs();
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public ArrayDeque<ArrayDeque<Character>> getGrid() {
        return grid;
    }

    public void setGrid(ArrayDeque<ArrayDeque<Character>> grid) {
        this.grid = grid;
    }

    public HashSet<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(HashSet<Bug> bugs) {
        this.bugs = bugs;
    }

    public boolean isGoalState() {
        return bugs.isEmpty();
    }

    public Optional<State> performAction(Action action){
        State clonedState = new State(this);

        // initial position of the bug
        int initialXBug = action.getBug().getRow();
        int initialYBug = action.getBug().getColumn();

        // new position of the bug
        int newXBug = initialXBug;
        int newYBug = initialXBug;

        switch (action.getDirection()){
            case UP:
                newXBug--;
                break;
            case DOWN:
                newXBug++;
                break;
            case LEFT:
                newYBug--;
                break;
            case RIGHT:
                newYBug++;
                break;
        }

        // check if the new position is valid
        //not sure if "==" works here or should i use .equals()
        if(this.grid[newXBug][newYBug] == 'B ')

    }
}
