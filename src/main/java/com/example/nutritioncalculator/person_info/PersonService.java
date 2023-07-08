package com.example.nutritioncalculator.person_info;

import com.example.nutritioncalculator.person_info.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository repository;

    // CREATE
    public void createPerson(PersonDTO dto) {
        repository.save(PersonEntity.getInstance(dto));
    }

    // READ
    public PersonDTO read(Long personId) {
        Optional<PersonEntity> optionalEntity = repository.findById(personId);
        if (optionalEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return PersonDTO.fromEntity(optionalEntity.get());
    }

    // UPDATE
    public void update(PersonDTO dto, Long personId) {
        Optional<PersonEntity> optionalEntity = repository.findById(personId);
        if (optionalEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        PersonEntity person = optionalEntity.get();
        person.update(dto);
        repository.save(person);
    }

    // DELETE
    public void deletePerson(Long personId) {
        Optional<PersonEntity> optionalEntity = repository.findById(personId);
        if (optionalEntity.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        repository.deleteById(personId);
    }
}
