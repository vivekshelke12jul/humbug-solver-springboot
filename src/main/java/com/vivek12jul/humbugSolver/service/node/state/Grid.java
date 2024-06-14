package com.vivek12jul.humbugSolver.service.node.state;

import java.util.Arrays;

public class Grid {

    // in future we can use ArrayList<ArrayList<Tile>>, Where Tile will be another class,
    // class BlankTile inherits from Tile,
    // class bugTile inherits from Tile,
    // class StartTile inherits from Tile,
    // class Unreachable inherits from Tile
    // or simply use a Tile enum
    private char[][] matrix;

    public Grid() {}

    public Grid(char[][] matrix) {
        this.setMatrix(matrix);
    }

    public Grid(Grid grid) {
        this.setMatrix(grid.getMatrix());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Grid grid = (Grid) obj;
        return Arrays.deepEquals(matrix, grid.matrix);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(matrix);
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = new char[matrix.length][matrix[0].length];
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                this.matrix[i][j] = matrix[i][j];
            }
        }
    }

    public void printGrid() {
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == ' ') {
                    System.out.print('░');
                } else if (matrix[i][j] == '*') {
                    System.out.print('*');
                } else if (matrix[i][j] == '#') {
                    System.out.print('█');
                } else if (matrix[i][j] == 'B') {
                    System.out.print('©');
                }
            }
            System.out.println();
        }
    }
}

