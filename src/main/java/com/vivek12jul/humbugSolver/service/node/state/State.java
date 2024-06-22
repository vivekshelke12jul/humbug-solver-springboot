package com.vivek12jul.humbugSolver.service.node.state;

import com.vivek12jul.humbugSolver.service.node.state.action.Action;
import com.vivek12jul.humbugSolver.service.node.state.action.bug.Bug;

import java.util.*;

public class State {
    private int rows;
    private int columns;
    private Grid grid;
    private HashSet<Bug> bugs;

    public State(){}

    public State(int rows, int columns, Grid grid, HashSet<Bug> bugs) {
        this.setRows(rows);
        this.setColumns(columns);
        this.setGrid(grid);
        this.setBugs(bugs);
    }

    // Copy constructor
    public State(State state){
        this.setRows(state.getRows());
        this.setColumns(state.getColumns());
        this.setGrid(state.getGrid());
        this.setBugs(state.getBugs());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        State state = (State) obj;
        return rows == state.rows &&
                columns == state.columns &&
                Objects.equals(grid, state.grid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rows, columns, grid);
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

    public Grid getGrid() {
        return grid;
    }

    public void setGrid(Grid grid) {
        this.grid = new Grid(grid);
    }

    public HashSet<Bug> getBugs() {
        return bugs;
    }

    public void setBugs(HashSet<Bug> bugs) {
        this.bugs = new HashSet<>(bugs);
    }

    @Override
    public String toString() {
        return "State{" +
                "rows=" + rows +
                ", columns=" + columns +
                ", grid=" + grid +
                ", bugs=" + bugs +
                '}';
    }

    public void printState() {
        System.out.println("\n================ State ===============");
        System.out.println("Grid: ");
        grid.printGrid();
        System.out.println("\n---------------------------------------\n");
//        System.out.println("Bugs: ");
//        for(Bug bug : bugs) {
//            System.out.println(bug.toString());
//        }
//        System.out.println("\n---------------------------------------\n");
    }

    public boolean isGoalState() {
        return bugs.isEmpty();
    }

//    public boolean isValidAcion(Action action){
//        int initialXBug = action.getBug().getRow();
//        int initialYBug = action.getBug().getColumn();
//
//        // new position of the bug
//        int midXBug = initialXBug;
//        int midYBug = initialYBug;
//
//        int newXBug = initialXBug;
//        int newYBug = initialYBug;
//
//        switch (action.getDirection()){
//            case UP:
//                midXBug -= 1;
//                newXBug -= 2;
//                break;
//            case DOWN:
//                midXBug += 1;
//                newXBug += 2;
//                break;
//            case LEFT:
//                midYBug -= 1;
//                newYBug -= 2;
//                break;
//            case RIGHT:
//                midYBug += 1;
//                newYBug += 2;
//                break;
//        }
//
//        // check if the new position/path is Invalid => return false
//        if(
//            newXBug < 0 || newXBug >= this.rows ||
//            newYBug < 0 || newYBug >= this.columns ||
//            this.grid.getMatrix()[midXBug][midYBug] == '#' ||
//            this.grid.getMatrix()[newXBug][newYBug] == 'B' ||
//            this.grid.getMatrix()[newXBug][newYBug] == '#'){
//            return false;
//        }
//        return true;
//    }

    public Optional<State> performAction(Action action){

        State clonedState = new State(this);
        Bug bug = action.getBug();
        Action.Direction direction = action.getDirection();
        Optional<State> newState = switch (direction) {
            case UP -> bug.moveUP(clonedState);
            case DOWN -> bug.moveDOWN(clonedState);
            case LEFT -> bug.moveLEFT(clonedState);
            case RIGHT -> bug.moveRIGHT(clonedState);
            default -> Optional.empty();
        };

        return newState;

        // initial position of the bug
//        int initialXBug = action.getBug().getRow();
//        int initialYBug = action.getBug().getColumn();
//
//        // new position of the bug
//        int newXBug = initialXBug;
//        int newYBug = initialYBug;
//
//        switch (action.getDirection()){
//            case UP:
//                newXBug -= 2;
//                break;
//            case DOWN:
//                newXBug += 2;
//                break;
//            case LEFT:
//                newYBug -= 2;
//                break;
//            case RIGHT:
//                newYBug += 2;
//                break;
//        }
//
//        // remove bug from old position
//        clonedState.getGrid().getMatrix()[initialXBug][initialYBug] = ' ';
//        clonedState.getBugs().remove(action.getBug());
//
//        //check if the new position is '*' => add empty tile to new position, because('B' + '*' = ' ')
//        if(this.grid.getMatrix()[newXBug][newYBug] == '*'){
//            clonedState.getGrid().getMatrix()[newXBug][newYBug] = ' ';
//            // no need to add a new bug to new position
//        }
//        else if(this.grid.getMatrix()[newXBug][newYBug] == ' '){
//            clonedState.getGrid().getMatrix()[newXBug][newYBug] = 'B';
//            clonedState.getBugs().add(new Bug(newXBug, newYBug, "Snail"));
//        }
//
//        return Optional.of(clonedState);
    }

}
