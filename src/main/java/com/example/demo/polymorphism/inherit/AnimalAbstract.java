package com.example.demo.polymorphism.inherit;

import lombok.Data;

@Data
public abstract class AnimalAbstract {

    private String name;

    public AnimalAbstract(String name) {
        this.name = name;
    }

    public abstract void talk();

    public abstract void eat();
}
