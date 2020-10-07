package io.stahlferro.mangorhodes.services;

import io.stahlferro.mangorhodes.models.primary.Department;
import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    public List<Department> getAll() {
        return repository.findAll();
    }

    public Department getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Department getByIdOrError(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Department with this id is not found: " + id));
    }

    public List<Room> getRoomsById(UUID id) {
        Department department = this.getByIdOrError(id);
        return new ArrayList<>(department.getRooms());
    }

    public Department add(Department department) {
        UUID extId = department.getId();
        if (extId != null && this.getById(extId) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department with this id already exists!");
        }
        else {
            return repository.save(department);
        }
    }

    public String delete(UUID id) {
        Department department = this.getByIdOrError(id);
        String deletionMsg = String.format("Deleted %s", department.toString());
        repository.delete(department);
        return deletionMsg;
    }
}
