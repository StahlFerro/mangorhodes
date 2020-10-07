package io.stahlferro.mangorhodes.services;

import io.stahlferro.mangorhodes.models.primary.Keycard;
import io.stahlferro.mangorhodes.repositories.primary.KeycardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class KeycardService {
    @Autowired
    private KeycardRepository repository;

    public Keycard getKeycardById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Keycard getKeycardByIdOrError(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Keycard with this id is not found: " + id));
    }

    public Keycard add(Keycard keycard) {
        return repository.save(keycard);
    }

    public String delete(Keycard keycard) {
        String deletionMsg = String.format("Deleted %s", keycard.toString());
        repository.delete(keycard);
        return deletionMsg;
    }
}
