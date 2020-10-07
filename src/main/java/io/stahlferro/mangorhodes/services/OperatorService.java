package io.stahlferro.mangorhodes.services;

import io.stahlferro.mangorhodes.models.primary.Operator;
import io.stahlferro.mangorhodes.repositories.primary.OperatorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
public class OperatorService {
    @Autowired
    private OperatorRepository repository;

    public Operator getOperatorById(UUID id) {
        return repository.findById(id).orElse(null);
    }

    public Operator getOperatorByIdOrError(UUID id) {
        return repository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Operator with this id is not found: " + id));
    }

    public Operator add(Operator operator) {
        return repository.save(operator);
    }

    public String delete(Operator operator) {
        String deletionMsg = String.format("Deleted %s", operator.toString());
        repository.delete(operator);
        return deletionMsg;
    }
}
