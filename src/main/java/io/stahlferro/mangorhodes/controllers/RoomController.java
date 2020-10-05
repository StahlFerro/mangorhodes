package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

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
        return new ResponseEntity<>(repository.save(room), HttpStatus.CREATED);
    }
}
