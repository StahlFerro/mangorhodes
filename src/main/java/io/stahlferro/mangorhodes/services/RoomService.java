package io.stahlferro.mangorhodes.services;

import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
public class RoomService {
    @Autowired
    private RoomRepository repository;

    public Room getById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Room getByIdOrError(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Room with this id is not found: " + id));
    }

    public List<Room> getAll() {
        return repository.findAll();
    }

    public Room add(Room room) {
        UUID extId = room.getId();
        if (extId != null && this.getById(extId) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Room with this id already exists!");
        }
        else {
            return repository.save(room);
        }
    }

    public String delete(UUID id) {
        Room room = this.getByIdOrError(id);
        String deletionMsg = String.format("Deleted Room with ID: " + room.toString());
        repository.delete(room);
        return deletionMsg;
    }
}
