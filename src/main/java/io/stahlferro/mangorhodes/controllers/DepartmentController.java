package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Department;
import io.stahlferro.mangorhodes.repositories.primary.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;
    @GetMapping()
    public ResponseEntity<List<Department>> fetchAllDepartments() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(repository.save(department), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") UUID uuid) {
        Department department = repository.findById(uuid).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Department ID: " + uuid));
        repository.delete(department);
        return new ResponseEntity("Department deleted with ID: " + uuid, HttpStatus.OK);
    }
}
