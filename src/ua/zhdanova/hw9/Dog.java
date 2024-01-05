package ua.zhdanova.hw9;

    class Dog extends Animal {
        public Dog(String name, int age) {
            super(name, age);
        }
        @Override
        public void makeSound() {
            System.out.println(name + " barks.");
        }
        public void playFetch() {
            System.out.println(name + " is playing fetch.");
        }
    }

