package com.vivek12jul.humbugSolver.node;

import com.vivek12jul.humbugSolver.node.state.action.Action;
import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;
import com.vivek12jul.humbugSolver.node.state.State;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Optional;

public class Node {

    private State state;
    private Node parent;
    private Action action;
    private int depth;

    public Node(State state, Node parent, Action action, int depth) {
        this.state = state;
        this.parent = parent;
        this.action = action;
        this.depth = depth;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
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
        for(Bug bug: this.state.getBugs()){

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
