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
        System.out.println("Inside getsoln");
        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();
//            System.out.println("node" + currentNode.hashCode());
            System.out.println(visitedStates.size());
            currentNode.getState().printState();//<==========================================================

            if (currentNode.getState().isGoalState()) {
                System.out.println("goal node found");

                this.solution = new Solution();
                while (currentNode.getParent() != null) {
                    // addAction method is adding action from front;
                    this.solution.addAction(currentNode.getAction());
                    currentNode = currentNode.getParent();
                }

                this.solution.setTotalVisitedStates(visitedStatesCount);
                return Optional.of(solution);
            }

            ArrayDeque<Node> children = currentNode.getChildren();
            for (Node child : children) {
                if (!visitedStates.contains(child.getState())) {
                    queue.addLast(child);
                    visitedStates.add(child.getState());
                    visitedStatesCount++;
                }
            }
        }
        return Optional.empty();
    }
}