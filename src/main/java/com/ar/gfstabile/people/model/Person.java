package com.ar.gfstabile.people.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "people")
public record Person(@Id @Field("_id") ObjectId id, @Field("name") String name, @Field("surname") String surname,
                @Field("document") com.ar.gfstabile.people.model.Document document) {

}
