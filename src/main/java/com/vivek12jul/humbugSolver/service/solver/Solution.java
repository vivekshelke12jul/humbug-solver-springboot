package com.vivek12jul.humbugSolver.service.solver;

import com.vivek12jul.humbugSolver.dao.ResponseEntity;
import com.vivek12jul.humbugSolver.service.node.state.State;
import com.vivek12jul.humbugSolver.service.node.state.action.Action;

import java.util.ArrayDeque;

public class Solution {

    ArrayDeque<Action> actions;
    ArrayDeque<State> states;
    int totalVisitedStates;

    Solution(){
        actions = new ArrayDeque<>();
        states = new ArrayDeque<>();
        totalVisitedStates = 0;
    }

    public void addAction(Action action){
        actions.addFirst(action);
    }

    public ArrayDeque<Action> getActions(){
        return actions;
    }

    public void addState(State state){
        states.addFirst(state);
    }
    public ArrayDeque<State> getStates(){
        return states;
    }

    public int getTotalVisitedStates(){
        return totalVisitedStates;
    }

    public void setTotalVisitedStates(int totalVisitedStates){
        this.totalVisitedStates = totalVisitedStates;
    }

    public void toResponseEntity(){
        ResponseEntity responseEntity = new ResponseEntity();

    }
}
