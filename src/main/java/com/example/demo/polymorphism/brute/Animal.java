package com.example.demo.polymorphism.brute;

import lombok.Data;

@Data
public class Animal {

    public static final int DOG = 0;
    public static final int CAT = 1;
    public static final int BIRD = 2;

    //新增需求來了
    //新增一隻狐狸
    public static final int FOX = 3;

    private String name;
    private int type;

    public Animal(String name, int type) {
        this.name = name;
        this.type = type;
    }

    public void talk() {
        System.out.print("我是" + this.getName() + ":");
        switch (this.getType()) {
            case Animal.BIRD:
                System.out.println("吱吱");
                break;
            case Animal.DOG:
                System.out.println("汪汪");
                break;
            case Animal.CAT:
                System.out.println("喵喵");
                break;
            //新增狐狸
            case Animal.FOX:
                System.out.println("狐狸叫");
                break;
            default:
                break;
        }
    }

    //新增覓食方法，也需要使用switch..case來判斷物種..
    public void eat() {
        System.out.print("我是" + this.getName() + ":");
        switch (this.getType()) {
            case Animal.BIRD:
                System.out.println("吃米");
                break;
            case Animal.DOG:
                System.out.println("吃肉");
                break;
            case Animal.CAT:
                System.out.println("吃魚");
                break;
            //新增狐狸
            case Animal.FOX:
                System.out.println("也吃肉");
                break;
            default:
                break;
        }
    }
}

