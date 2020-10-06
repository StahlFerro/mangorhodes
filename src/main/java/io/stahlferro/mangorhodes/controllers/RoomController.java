package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Department;
import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/room")
public class RoomController {
    @Autowired
    private RoomRepository repository;
    @GetMapping()
    public ResponseEntity<List<Room>> fetchAllRooms() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room) {
        repository.save(room);
        return new ResponseEntity<>(room, HttpStatus.CREATED);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") UUID uuid) {
        Room room = repository.findById(uuid).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Room ID: " + uuid));
        repository.delete(room);
        return new ResponseEntity("Room deleted with ID: " + uuid, HttpStatus.OK);
    }
}
