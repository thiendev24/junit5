package com.junit5.model;

import lombok.*;

@NoArgsConstructor
@Data
public class TolkienCharacter {

    private int age;

    private String name;

    private Race race;

    public TolkienCharacter(int age, String name, Race race) {
        setAge(age);
        this.name = name;
        this.race = race;
    }

    public TolkienCharacter(int age, String name) {
        this(age, name, null);
    }

    // not accessible field to test that field by field comparison does not use it
    @SuppressWarnings("unused")
    private final long notAccessibleField = System.currentTimeMillis();

    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age is not allowed to be smaller than zero");
        }
        this.age = age;
    }

}
