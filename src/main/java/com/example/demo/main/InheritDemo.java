package com.example.demo.main;

public class InheritDemo {

	public static void main(String[] args) {
		Animal dogAnimal = new Dog();
		Dog dog = (Dog)dogAnimal;
		dog.bark();

	}

}

class Animal{
	
    int height;
    int weight;
    int age;
    
    void move(){
    	
    } 
} 

class Dog extends Animal{

    public void bark(){
    	
    }
} 




