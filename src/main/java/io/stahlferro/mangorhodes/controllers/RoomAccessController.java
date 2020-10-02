package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.secondary.RoomAccess;
import io.stahlferro.mangorhodes.repositories.secondary.RoomAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/room-access")
public class RoomAccessController {
    @Autowired
    private RoomAccessRepository repository;
    @GetMapping()
    public ResponseEntity<List<RoomAccess>> fetchAllRoomAccesses() {
        return new ResponseEntity<>(repository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<RoomAccess> addRoomAccess(@Valid @RequestBody RoomAccess roomAccess) {
        repository.save(roomAccess);
        return new ResponseEntity<>(roomAccess, HttpStatus.CREATED);
    }
}
