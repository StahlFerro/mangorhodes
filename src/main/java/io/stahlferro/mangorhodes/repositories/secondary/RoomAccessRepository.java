package io.stahlferro.mangorhodes.repositories.secondary;

import io.stahlferro.mangorhodes.models.secondary.RoomAccess;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RoomAccessRepository extends MongoRepository<RoomAccess, Long> {
    List<RoomAccess> findByAccessType(RoomAccess.AccessType accessType);
}
