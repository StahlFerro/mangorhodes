package io.stahlferro.mangorhodes.repositories.primary;

import io.stahlferro.mangorhodes.models.primary.KeycardCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface KeycardCategoryRepository extends JpaRepository<KeycardCategory, UUID> {
    KeycardCategory findByAccessLevel(int accessLevel);
}
