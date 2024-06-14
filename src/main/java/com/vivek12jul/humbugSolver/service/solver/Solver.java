package com.vivek12jul.humbugSolver.service.solver;

import com.vivek12jul.humbugSolver.dao.ResponseEntity;
import com.vivek12jul.humbugSolver.service.node.Node;
import com.vivek12jul.humbugSolver.service.node.state.State;

import java.util.*;


// In future make solver an Interface
public class Solver {

    private Node startNode;

    private ArrayDeque<Node> queue;

    private HashSet<State> visitedStates;

    private int visitedStatesCount;


    public Solver(State state) {
        this.startNode = new Node(state, null, null, 0);
        this.queue = new ArrayDeque<>();
        this.queue.add(this.startNode);

        this.visitedStates = new HashSet<>();
        this.visitedStates.add(this.startNode.getState());
        this.visitedStatesCount = 1;
    }


    public ResponseEntity getSolution() {
        System.out.println("Inside getsoln");
        while (!queue.isEmpty()) {
            Node currentNode = queue.removeFirst();
            System.out.println("Exploring Node@hashcode=" + currentNode.hashCode());
//            currentNode.getState().printState();//<==========================================================

            if (currentNode.getState().isGoalState()) {
                System.out.println("goal node found");
                // Goal node is found return the solution in form of responseEntity;
                ResponseEntity responseEntity = new ResponseEntity(true);

                while (currentNode.getParent() != null) {

                    responseEntity.prependInSolutionPath(currentNode);
                    currentNode = currentNode.getParent();
                }
                responseEntity.setTotalVisitedStates(visitedStatesCount);
                System.out.println("solutionPath Created");

                return responseEntity;
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
        return new ResponseEntity(false);
    }
}