package com.vivek12jul.humbugSolver.node.state.action.bug;

public class Bug {

    private int row;
    private int column;

    private String type;

    public Bug(int row, int column, String type) {
        this.row = row;
        this.column = column;
        this.type = type;
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
