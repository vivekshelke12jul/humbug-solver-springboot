package com.vivek12jul.humbugSolver.temp;

import com.vivek12jul.humbugSolver.node.state.Grid;
import com.vivek12jul.humbugSolver.node.state.State;
import com.vivek12jul.humbugSolver.node.state.action.Action;
import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;

import java.util.HashSet;

public class Temp {

    public static void main(String[] args) {

        Bug bug = new Bug(0,0,"snail");
        Bug bug2 = new Bug(0,0,"snail");

        Action action = new Action(bug, Action.Direction.UP);

        char [][] matrix = {
                {'B',' '},
                {' ','*'}
        };

        Grid grid = new Grid(matrix);
        HashSet<Bug> bugs1 = new HashSet<>();
//        bugs1.add(bug);
//        State state1 = new State(2, 2, grid, bugs1);
//        state1.printState();
//        System.out.println(state1.hashCode());
//
//        state1.getGrid().getMatrix()[0][0] = '*';
//        state1.getGrid().getMatrix()[1][1] = 'B';
//
//        state1.printState();
//        System.out.println(state1.hashCode());

        bugs1.add(bug);
        bugs1.add(bug2);

        for(Bug mbug : bugs1) {
            System.out.println(mbug.toString());
        }
    }

}
