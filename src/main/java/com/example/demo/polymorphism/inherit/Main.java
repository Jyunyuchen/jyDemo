package com.example.demo.polymorphism.inherit;

import com.example.demo.polymorphism.brute.Animal;

public class Main {
    public static void main(String[] args) {

        AnimalAbstract[] animals = new AnimalAbstract[]{
                new Dog("狗"),
                new Cat("貓")
        };

        for (AnimalAbstract animal : animals) {
            animal.talk();
        }
    }
}
