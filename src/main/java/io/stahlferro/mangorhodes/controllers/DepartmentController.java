package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Department;
import io.stahlferro.mangorhodes.repositories.primary.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        repository.save(department);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
}
