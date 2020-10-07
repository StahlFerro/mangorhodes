package io.stahlferro.mangorhodes.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.stahlferro.mangorhodes.models.primary.Room;
import io.stahlferro.mangorhodes.repositories.primary.RoomRepository;
import io.stahlferro.mangorhodes.services.RoomService;
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
@RequestMapping("/api/rooms")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping()
    public ResponseEntity<List<Room>> fetchAllRooms() {
        return new ResponseEntity<>(roomService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> fetchRoomById(@PathVariable("id") UUID id) {
        return new ResponseEntity<>(roomService.getByIdOrError(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<Room> addRoom(@Valid @RequestBody Room room) throws Exception {
        return new ResponseEntity<>(roomService.add(room), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteRoom(@PathVariable("id") UUID id) {
        String deletionMsg = roomService.delete(id);
        return new ResponseEntity(deletionMsg, HttpStatus.OK);
    }
}
