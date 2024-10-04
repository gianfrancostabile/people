package com.ar.gfstabile.people.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PersonDto(@JsonProperty("name") String name, @JsonProperty("surname") String surname,
                @JsonProperty("document") DocumentDto document) implements Serializable {
}
