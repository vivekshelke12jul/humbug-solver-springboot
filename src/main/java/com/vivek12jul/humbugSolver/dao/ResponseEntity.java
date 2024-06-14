package com.vivek12jul.humbugSolver.dao;

import java.util.ArrayDeque;
import java.util.ArrayList;

import com.vivek12jul.humbugSolver.service.node.Node;
import com.vivek12jul.humbugSolver.service.node.state.State;
import com.vivek12jul.humbugSolver.service.node.state.action.Action;

public class ResponseEntity {


    private Boolean isSolvable;
    private int totalVisitedStates;
    private ArrayDeque<char[][]> solutionMatrixList;
    private ArrayDeque<Action> solutionActionList;

    public ResponseEntity() {}

    public ResponseEntity(Boolean isSolvable) {
        this.isSolvable = isSolvable;
        this.totalVisitedStates = 0;
        this.solutionMatrixList = new ArrayDeque<>();
        this.solutionActionList = new ArrayDeque<>();
    }

    public Boolean getIsSolvable() {
        return isSolvable;
    }

    public void setIsSolvable(Boolean isSolvable) {
        this.isSolvable = isSolvable;
    }

    public int getTotalVisitedStates() {
        return totalVisitedStates;
    }

    public void setTotalVisitedStates(int visitedStatesCount) {
        this.totalVisitedStates = visitedStatesCount;
    }

    public ArrayDeque<char[][]> getSolutionMatrixList() {
        return solutionMatrixList;
    }

    public ArrayDeque<Action> getSolutionActionList() {
        return solutionActionList;
    }

    public void prependInSolutionPath(Node node){
        char[][] matrix = node.getState().getGrid().getMatrix();
        Action action = node.getAction();

        solutionMatrixList.addFirst(matrix);
        solutionActionList.addFirst(action);
    }


}
