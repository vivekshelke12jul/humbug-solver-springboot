package com.vivek12jul.humbugSolver.node;

import com.vivek12jul.humbugSolver.node.state.Grid;
import com.vivek12jul.humbugSolver.node.state.action.Action;
import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;
import com.vivek12jul.humbugSolver.node.state.State;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class Node {

    private State state;
    private Node parent;
    private Action action;
    private int depth;

    public Node(State state, Node parent, Action action, int depth) {
        this.setState(state);
        this.setParent(parent);
        this.setAction(action);
        this.setDepth(depth);
    }

    //No need for a copy constructor in Node class;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = new State(state.getRows(), state.getColumns(), new Grid(state.getGrid()), state.getBugs());
    }

    public Node getParent() {
        return parent;
    }

    // assigning reference of parent node directly, not making a copy of parent
    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        if(action == null){
            this.action = null;
        }else{
            this.action = new Action(new Bug(action.getBug()), action.getDirection());
        }
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        return "Node{" +
                "state=" + state +
                ", parent=" + parent +
                ", action=" + action +
                ", depth=" + depth +
                '}';
    }

    public ArrayDeque<Node> getChildren() {
        ArrayDeque<Node> children = new ArrayDeque<>();

        //iterate through all the bugs
//        for(Bug bug: this.state.getBugs()){
        for(Iterator<Bug> bugi = this.state.getBugs().iterator(); bugi.hasNext(); ){
            Bug bug = bugi.next();

            //iterate through all the actions (UP, DOWN, RIGHT, LEFT)
            for(Action.Direction direction : Action.Direction.values()){

                Action action = new Action(bug, direction);
                Optional<State> newState = this.state.performAction(action);
                newState.ifPresent(value -> children.add(new Node(value, this, action, this.depth + 1)));
            }
        }
        return children;
    }
}
