package com.ar.gfstabile.people.mapper;

import org.mapstruct.Mapper;

import com.ar.gfstabile.people.dto.PersonDto;
import com.ar.gfstabile.people.model.Person;

@Mapper(componentModel = "spring")
public interface PeopleMapper {

    PersonDto map(Person person);

    Person map(PersonDto people);
}
