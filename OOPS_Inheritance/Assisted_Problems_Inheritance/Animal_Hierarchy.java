// Animal Hierarchy
// Description: Create a hierarchy where Animal is the superclass, and Dog, Cat, and Bird are subclasses. Each subclass has a unique behavior.
// Tasks:
// Define a superclass Animal with attributes name and age, and a method makeSound().
// Define subclasses Dog, Cat, and Bird, each with a unique implementation of makeSound().
// Goal: Learn basic inheritance, method overriding, and polymorphism with simple classes.



package OOPS_Inheritance.Assisted_Problems_Inheritance;

public class Animal_Hierarchy {
    
    String name;
    int age;

    Animal_Hierarchy(String name, int age){
        this.name=name;
        this.age=age;
    }

    void makeSound() {
        System.out.println("Animal is making sound");
    }

}
