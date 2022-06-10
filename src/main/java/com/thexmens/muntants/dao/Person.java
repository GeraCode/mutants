package com.thexmens.muntants.dao;

import lombok.Builder;
import lombok.Data;

import lombok.extern.jackson.Jacksonized;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="persons")
@Data
@Jacksonized
@Builder
public class Person {

    private String adn;
    private Boolean is_mutant;
}
