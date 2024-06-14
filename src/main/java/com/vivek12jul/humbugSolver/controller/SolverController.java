package com.vivek12jul.humbugSolver.controller;


import com.vivek12jul.humbugSolver.dao.RequestEntity;
import com.vivek12jul.humbugSolver.dao.ResponseEntity;
import com.vivek12jul.humbugSolver.service.node.state.State;
import com.vivek12jul.humbugSolver.service.solver.Solution;
import com.vivek12jul.humbugSolver.service.solver.Solver;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*")
@RestController
public class SolverController {

    @PostMapping("/get-solution")
    public ResponseEntity getSolution(@Valid @RequestBody RequestEntity requestEntity){
        System.out.println("Request received.");
        State state = requestEntity.toState();
        return new Solver(state).getSolution();

    }
}
