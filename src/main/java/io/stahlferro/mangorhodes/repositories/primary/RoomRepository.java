package io.stahlferro.mangorhodes.repositories.primary;

import io.stahlferro.mangorhodes.models.primary.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoomRepository extends JpaRepository<Room, UUID> {

}
