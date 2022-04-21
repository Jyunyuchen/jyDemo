package com.example.demo.polymorphism.inherit;

public class Dog extends AnimalAbstract {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void talk() {
        System.out.print("我是" + this.getName() + ":");
        System.out.println("汪汪");
    }

    @Override
    public void eat() {
        System.out.println("吃肉");
    }
}
