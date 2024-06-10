package com.vivek12jul.humbugSolver.node.state.action;

import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;

public class Action {

    private Bug bug;
    private Direction direction;
    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    public Action(Bug bug, Direction direction) {
        this.bug = bug;
        this.direction = direction;
    }



    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Bug getBug() {
        return bug;
    }

    public void setBug(Bug bug) {
        this.bug = bug;
    }

}
