package com.vivek12jul.humbugSolver.service.node.state.action.bug;

import com.vivek12jul.humbugSolver.service.node.state.State;

import java.util.Objects;
import java.util.Optional;

public abstract class Bug {

    private int row;
    private int column;

    private BugType type;

    Bug(){}

    public Bug(int row, int column, BugType type) {
        this.row = row;
        this.column = column;
        this.type = type;
    }

//    public Bug(Bug bug) {
//        this.row = bug.getRow();
//        this.column = bug.getColumn();
//        this.type = bug.getType();
//    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Bug bug = (Bug) obj;
        return row == bug.row &&
                column == bug.column &&
                Objects.equals(type, bug.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column, type);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public BugType getType() {
        return type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setType(BugType type) {
        this.type = type;
    }

    public abstract Bug clone(); // Abstract method for cloning
    abstract public Optional<State> moveUP(State state);
    abstract public Optional<State>  moveDOWN(State state);
    abstract public Optional<State>  moveLEFT(State state);
    abstract public Optional<State>  moveRIGHT(State state);


    @Override
    public String toString() {
        return "Bug{" +
                "row=" + row +
                ", column=" + column +
                ", type='" + type + '\'' +
                '}';
    }
}
