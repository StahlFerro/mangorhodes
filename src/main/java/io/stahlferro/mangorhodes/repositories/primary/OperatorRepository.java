package io.stahlferro.mangorhodes.repositories.primary;

import io.stahlferro.mangorhodes.models.primary.Operator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OperatorRepository extends JpaRepository<Operator, UUID> {
    List<Operator> findByAccessLevel(int accessLevel);
}
