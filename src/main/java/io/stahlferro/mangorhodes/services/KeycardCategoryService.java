package io.stahlferro.mangorhodes.services;

import io.stahlferro.mangorhodes.models.primary.KeycardCategory;
import io.stahlferro.mangorhodes.repositories.primary.KeycardCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class KeycardCategoryService {
    @Autowired
    private KeycardCategoryRepository repository;

    public KeycardCategory getKeycardCategoryById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public KeycardCategory getKeycardCategoryByIdOrError(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "KeycardCategory with this id is not found: " + id));
    }

    public KeycardCategory add(KeycardCategory KeycardCategory) {
        return repository.save(KeycardCategory);
    }

    public String delete(KeycardCategory KeycardCategory) {
        String deletionMsg = String.format("Deleted %s", KeycardCategory.toString());
        repository.delete(KeycardCategory);
        return deletionMsg;
    }
}
