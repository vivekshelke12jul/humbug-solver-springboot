package com.vivek12jul.humbugSolver.solver;

import com.vivek12jul.humbugSolver.node.Node;
import com.vivek12jul.humbugSolver.node.state.State;

import java.util.*;

public class Solver {

    private Node startNode;

    private ArrayDeque<Node> queue;

    private HashSet<State> visitedStates;

    private int visitedStatesCount;

    Solution solution;

    Solver(State state) {
        this.startNode = new Node(state, null, null, 0);
        this.queue = new ArrayDeque<>();
        this.queue.add(this.startNode);

        this.visitedStates = new HashSet<>();
        this.visitedStates.add(this.startNode.getState());
        this.visitedStatesCount = 1;
        this.solution = new Solution();
    }


    public Optional<Solution> getSolution() {
        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();

            if (currentNode.getState().isGoalState()) {
                solution = new Solution();
                while (currentNode.getParent() != null) {
                    solution.addAction(currentNode.getAction());
                    currentNode = currentNode.getParent();
                }

                solution.setTotalVisitedStates(visitedStatesCount);
                return solution;
            }

            ArrayDeque<Node> children = currentNode.getChildren();
            for (Node child : children) {
                if (!visitedStates.contains(child.getState())) {
                    queue.add(child);
                    visitedStates.add(child.getState());
                    visitedStatesCount++;
                }
            }



}