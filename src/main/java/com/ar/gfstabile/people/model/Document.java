package com.ar.gfstabile.people.model;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ar.gfstabile.people.constant.DocumentType;

public record Document(@Field("type") DocumentType type, @Field("number") String number) {

}
