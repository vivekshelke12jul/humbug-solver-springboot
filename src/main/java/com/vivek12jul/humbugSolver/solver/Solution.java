package com.vivek12jul.humbugSolver.solver;

import com.vivek12jul.humbugSolver.node.state.action.Action;

import java.util.ArrayDeque;

public class Solution {

    ArrayDeque<Action> actions;
    int totalVisitedStates;

    Solution(){
        actions = new ArrayDeque<>();
        totalVisitedStates = 0;
    }

    public void addAction(Action action){
        actions.add(action);
    }

    public ArrayDeque<Action> getActions(){
        return actions;
    }

    public int getTotalVisitedStates(){
        return totalVisitedStates;
    }

    public void setTotalVisitedStates(int totalVisitedStates){
        this.totalVisitedStates = totalVisitedStates;
    }
}
