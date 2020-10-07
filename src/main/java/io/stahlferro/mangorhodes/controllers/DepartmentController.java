package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Department;
import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.DepartmentRepository;
import io.stahlferro.mangorhodes.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService service;
    @GetMapping()
    public ResponseEntity<List<Department>> fetchAllDepartments() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> fetchDepartmentById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(service.getByIdOrError(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/rooms")
    public ResponseEntity<List<Room>> fetchDepartmentRooms(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(service.getRoomsById(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Department> addDepartment(@Valid @RequestBody Department department) {
        return new ResponseEntity<>(service.add(department), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") UUID id) {
        String deletionMsg = service.delete(id);
        return new ResponseEntity<>(deletionMsg, HttpStatus.OK);
    }
}
