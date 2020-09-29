package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Operator;
import io.stahlferro.mangorhodes.repositories.primary.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/operator")
public class OperatorController {
    @Autowired
    private OperatorRepository repository;

    @PostMapping("/add")
    public ResponseEntity<Operator> addOperator(@RequestBody Operator operator) {
        repository.save(operator);
        return new ResponseEntity<>(operator, HttpStatus.CREATED);
    }
}
