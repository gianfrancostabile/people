package com.ar.gfstabile.people.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ar.gfstabile.people.dto.PersonDto;
import com.ar.gfstabile.people.service.PeopleService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/people")
public class PeopleController {

    @Autowired
    private PeopleService service;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid PersonDto request) {
        service.create(request);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/filter")
    public ResponseEntity<PersonDto> findByFilter(@RequestParam(required = false, value = "document_type") String type,
            @RequestParam(value = "document_number") String number) {
        Optional<PersonDto> result = service.findByFilter(type, number);
        if (!result.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(result.get());
    }

    @GetMapping
    public ResponseEntity<List<PersonDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

}
