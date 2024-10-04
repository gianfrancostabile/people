package com.ar.gfstabile.people.dto;

import java.io.Serializable;

import com.ar.gfstabile.people.constant.DocumentType;
import com.fasterxml.jackson.annotation.JsonProperty;

public record DocumentDto(@JsonProperty("type") DocumentType type, @JsonProperty("number") String number)
                implements Serializable {

}
