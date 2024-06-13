package com.vivek12jul.humbugSolver.node.state.action.bug;

import java.util.Objects;

public class Bug {

    private int row;
    private int column;

    private String type;

    Bug(){}

    public Bug(int row, int column, String type) {
        this.row = row;
        this.column = column;
        this.type = type;
    }

    public Bug(Bug bug) {
        this.row = bug.getRow();
        this.column = bug.getColumn();
        this.type = bug.getType();
    }

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

    public String getType() {
        return type;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Bug{" +
                "row=" + row +
                ", column=" + column +
                ", type='" + type + '\'' +
                '}';
    }
}
