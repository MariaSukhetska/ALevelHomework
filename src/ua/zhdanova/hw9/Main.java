package ua.zhdanova.hw9;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal("Generic Animal", 5);
        Dog dog = new Dog("Buddy", 2);
        animal.eat();
        animal.sleep();
        animal.makeSound();
        dog.eat();
        dog.sleep();
        dog.makeSound();
        dog.playFetch();

        MyClass myObject = new MyClass(7, "Bob");
        myObject.displayVariables();

        Peat cat = new Peat("Cat", 8, "Fish");
        Peat rabbit = new Peat("Rabbit", 10, "Grass");
        Peat sleepyAnimal = findSleepiestAnimal(cat, rabbit);
        System.out.println("The most hours of sleep: " + sleepyAnimal.getName());
        System.out.println("It eats: " + sleepyAnimal.getFood());
    }

    public static Peat findSleepiestAnimal(Peat cat, Peat rabbit) {
        if (cat.getHoursOfSleeping() >= rabbit.getHoursOfSleeping()) {
            return cat;
        } else {
            return rabbit;
        }
    }
}






