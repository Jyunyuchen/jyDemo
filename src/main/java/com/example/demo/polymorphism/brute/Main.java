package com.example.demo.polymorphism.brute;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[]{
                new Animal("鳥", Animal.BIRD),
                new Animal("狗", Animal.DOG),
                new Animal("貓", Animal.CAT),
                //新增狐狸
                new Animal("狐狸", Animal.FOX)
        };

        for (Animal animal : animals) {
            animal.talk();
            //將此區塊搬到Animal類別中
           /* System.out.print("我是" + animal.getName() + ":");
            switch (animal.getType()) {
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
            }*/
        }
    }
}
