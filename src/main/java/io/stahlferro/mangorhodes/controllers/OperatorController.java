package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Operator;
import io.stahlferro.mangorhodes.repositories.primary.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    @Autowired
    private OperatorRepository repository;
    @GetMapping
    public ResponseEntity<List<Operator>> fetchAllOperators() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);

    }

    @PostMapping("/add")
    public ResponseEntity<Operator> addOperator(@Valid @RequestBody Operator operator) {
        return new ResponseEntity<>(repository.save(operator), HttpStatus.CREATED);
    }
}
