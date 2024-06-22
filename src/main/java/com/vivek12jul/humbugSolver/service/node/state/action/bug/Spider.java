package com.vivek12jul.humbugSolver.service.node.state.action.bug;

import com.vivek12jul.humbugSolver.service.node.state.State;

import java.util.Optional;

public class Spider extends Bug {
    public Spider(int row, int column) {
        super(row, column, BugType.SPIDER);
    }


    @Override
    public Spider clone() {
        return new Spider(this.getRow(), this.getColumn());
    }

    @Override
    public Optional<State> moveUP(State state) {
        return Optional.empty();
    }

    @Override
    public Optional<State> moveDOWN(State state) {
        return Optional.empty();
    }

    @Override
    public Optional<State> moveLEFT(State state) {
        return Optional.empty();
    }

    @Override
    public Optional<State> moveRIGHT(State state) {
        return Optional.empty();
    }
}
