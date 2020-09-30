package io.stahlferro.mangorhodes.repositories.primary;

import io.stahlferro.mangorhodes.models.primary.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Department findByName(String name);
}
