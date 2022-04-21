package com.example.demo.polymorphism.inherit;

public class Cat extends AnimalAbstract {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void talk() {
        System.out.print("我是" + this.getName() + ":");
        System.out.println("喵喵");
    }

    @Override
    public void eat() {
        System.out.println("吃魚");
    }
}
