package com.vivek12jul.humbugSolver.dao;

import com.vivek12jul.humbugSolver.service.node.state.Grid;
import com.vivek12jul.humbugSolver.service.node.state.State;
import com.vivek12jul.humbugSolver.service.node.state.action.bug.Bug;

import java.util.HashSet;

public class RequestEntity {
    private int rows;
    private int columns;
    private char[][] matrix;

    public RequestEntity(){}

    public RequestEntity(int rows, int columns, char[][] matrix) {
        this.rows = rows;
        this.columns = columns;
        this.matrix = matrix;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

//    @Override
//    public String toString() {
//        return "RequestObject{" +
//                "rows=" + rows +
//                ", columns=" + columns +
//                ", grid=" + matrixToString(matrix) +
//                '}';
//    }

//    public String matrixToString(char [][] matrix) {
//        StringBuilder ans = new StringBuilder("{");
//
//        StringBuilder arr = new StringBuilder("[");
//        for(int i=0; i<matrix.length; i++) {
//
//            for(int j=0; j<matrix[0].length; j++){
//                arr.append(matrix[i][j] + ',');
//                System.out.print(matrix[i][j] + ",");
//            }arr.append("],");
//            System.out.println(arr.toString());
//
//        }ans.append(arr.toString());
//
//
//        ans.append("}");
//        return ans.toString();
//    }

    public State toState() {

        HashSet<Bug> bugs = new HashSet<>();
        for(int i=0; i<this.rows; i++){
            for(int j=0; j<this.columns; j++){
                if(this.matrix[i][j] == 'B'){
                    Bug bug = new Bug(i, j, "snail");
                    bugs.add(bug);
                }
            }
        }
        Grid grid = new Grid(this.matrix);

        return new State(rows, columns, grid, bugs);
    }
}
