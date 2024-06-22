package com.vivek12jul.humbugSolver.service.node.state.action.bug;

import com.vivek12jul.humbugSolver.service.node.state.State;

import java.util.Optional;

public class Snail extends Bug {
    public Snail(int row, int column) {
        super(row, column, BugType.SNAIL);
    }

    @Override
    public Snail clone() {
        return new Snail(this.getRow(), this.getColumn());
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
