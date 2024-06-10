package com.vivek12jul.humbugSolver.solver;


import com.vivek12jul.humbugSolver.node.state.State;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SolverController {

    @GetMapping("/get-solution")
    public Optional<Solution> getSolution(@Valid @RequestBody State state){
        return new Solver(state).getSolution();
    }
}
