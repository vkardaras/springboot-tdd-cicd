package com.example.catsservice;

import org.springframework.util.Assert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Cat {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;

    public Cat(String name) {
        Assert.isTrue(Character.isUpperCase(name.charAt(0)), () -> "the first character of the name must be uppercase");
        this.name = name;
    }

    Cat() {
    }

    public String getName() {
        return name;
    }
}
