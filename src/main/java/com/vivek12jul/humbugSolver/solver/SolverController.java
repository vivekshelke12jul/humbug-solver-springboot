package com.vivek12jul.humbugSolver.solver;


import com.vivek12jul.humbugSolver.http.RequestObject;
import com.vivek12jul.humbugSolver.node.state.State;
import com.vivek12jul.humbugSolver.node.state.action.bug.Bug;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;

@CrossOrigin("*")
@RestController
public class SolverController {

    @PostMapping("/get-solution")
    public Optional<Solution> getSolution(@Valid @RequestBody RequestObject requestObject){
        System.out.println("in controller");
        System.out.println(requestObject.toString());
        State state = requestObject.toState();
        HashSet<Bug> bugset = state.getBugs();
        System.out.println(bugset.size());
        return new Solver(state).getSolution();
    }
}
