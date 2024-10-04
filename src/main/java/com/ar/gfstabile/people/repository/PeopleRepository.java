package com.ar.gfstabile.people.repository;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.ar.gfstabile.people.model.Document;
import com.ar.gfstabile.people.model.Person;

public interface PeopleRepository extends MongoRepository<Person, ObjectId> {

    Optional<Person> findByDocument(Document document);

    boolean existsByDocument(Document document);
}
