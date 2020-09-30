package io.stahlferro.mangorhodes.repositories.primary;

import io.stahlferro.mangorhodes.models.primary.Keycard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface KeyCardRepository extends JpaRepository<Keycard, UUID> {
    Keycard findByNumber(long number);
}
