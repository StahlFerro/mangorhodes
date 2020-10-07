package io.stahlferro.mangorhodes.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.RoomRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Slf4j
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
    public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        log.info(mapper.writeValueAsString(room));
        Room savedRoom = repository.save(room);
        log.info(mapper.writeValueAsString(savedRoom));
        return new ResponseEntity<>(savedRoom, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") UUID uuid) {
        Room room = repository.findById(uuid).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Invalid Room ID: " + uuid));
        repository.delete(room);
        return new ResponseEntity("Room deleted with ID: " + uuid, HttpStatus.OK);
    }
}
