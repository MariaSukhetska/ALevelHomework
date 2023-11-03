package ua.zhdanova.hw9;

public class Animal {
        protected String name;
        protected int age;
        public Animal(String name, int age) {
            this.name = name;
            this.age = age;
        }
        public void eat() {
            System.out.println(name + " is eating.");
        }
        public final void sleep() {
            System.out.println(name + " is sleeping.");
        }
        public void makeSound() {
            System.out.println(name + " makes a generic animal sound.");
        }
    }
