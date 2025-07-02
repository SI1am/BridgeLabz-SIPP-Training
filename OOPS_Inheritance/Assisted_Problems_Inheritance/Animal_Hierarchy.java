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

    static class Dog extends Animal_Hierarchy {
        Dog(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " the Dog says: Woof Woof");
        }
    }

    static class Cat extends Animal_Hierarchy {
        Cat(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " the Cat says: Meow Meow");
        }
    }

    static class Bird extends Animal_Hierarchy {
        Bird(String name, int age) {
            super(name, age);
        }

        @Override
        void makeSound() {
            System.out.println(name + " the Bird says: Chirp Chirp");
        }
    }

    public static void main(String[] args) {
        Animal_Hierarchy[] animals = {
            new Dog("Buddy", 3),
            new Cat("Whiskers", 2),
            new Bird("Tweety", 1)
        };

        for (Animal_Hierarchy animal : animals) {
            animal.makeSound();
        }
    }
}
