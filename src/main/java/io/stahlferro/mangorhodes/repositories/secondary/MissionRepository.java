package io.stahlferro.mangorhodes.repositories.secondary;

import io.stahlferro.mangorhodes.models.secondary.Mission;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface MissionRepository extends MongoRepository<Mission, Long> {
    List<Mission> findByType();
}
