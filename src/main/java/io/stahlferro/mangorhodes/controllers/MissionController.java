package io.stahlferro.mangorhodes.controllers;

import io.stahlferro.mangorhodes.models.secondary.Mission;
import io.stahlferro.mangorhodes.repositories.secondary.MissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/missions")
public class MissionController {

    @Autowired
    private MissionRepository repository;

    @PostMapping()
    public ResponseEntity<Mission> addMission(@Valid @RequestBody Mission mission) {
        return new ResponseEntity<>(repository.save(mission), HttpStatus.CREATED);
    }
}
