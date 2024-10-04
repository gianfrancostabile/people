package com.ar.gfstabile.people.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.ar.gfstabile.people.constant.DocumentType;
import com.ar.gfstabile.people.dto.PersonDto;
import com.ar.gfstabile.people.mapper.PeopleMapper;
import com.ar.gfstabile.people.model.Document;
import com.ar.gfstabile.people.model.Person;
import com.ar.gfstabile.people.repository.PeopleRepository;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private PeopleMapper peopleMapper;

    public void create(PersonDto request) {
        Person person = peopleMapper.map(request);
        if (repository.existsByDocument(person.document())) {
            throw new Error("product code already exist");
        }
        repository.save(person);
    }

    public Optional<PersonDto> findByFilter(String type, String number) {
        if (!StringUtils.hasText(number)) {
            throw new Error("code is required");
        }
        if (!StringUtils.hasText(type)) {
            type = DocumentType.DU.getValue();
        }
        return repository.findByDocument(new Document(DocumentType.valueOf(type), number)).map(peopleMapper::map);
    }

    public List<PersonDto> findAll() {
        return repository.findAll().stream().map(peopleMapper::map).collect(Collectors.toList());
    }

}
