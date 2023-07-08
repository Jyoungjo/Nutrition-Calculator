package com.example.nutritioncalculator.person_info;

import com.example.nutritioncalculator.ResponseDTO;
import com.example.nutritioncalculator.person_info.dto.PersonDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {
    private final PersonService service;

    @PostMapping
    public ResponseEntity<ResponseDTO> create(@RequestBody PersonDTO dto) {
        service.createPerson(dto);
        return ResponseEntity.ok(ResponseDTO.getInstance("신체 정보가 등록되었습니다."));
    }

    @GetMapping("/{personId}")
    public ResponseEntity<PersonDTO> readOne(@PathVariable("personId") Long personId) {
        return ResponseEntity.ok(service.read(personId));
    }

    @PutMapping("/{personId}")
    public ResponseEntity<ResponseDTO> update(@PathVariable("personId") Long personId, @RequestBody PersonDTO dto) {
        service.update(dto, personId);
        return ResponseEntity.ok(ResponseDTO.getInstance("신체 정보가 변경되었습니다."));
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable("personId") Long personId) {
        service.deletePerson(personId);
        return ResponseEntity.ok(ResponseDTO.getInstance("삭제가 완료되었습니다."));
    }
}
