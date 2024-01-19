package ua.zhdanova.hw21.builder;

public class Main {
    public static void main(String[] args) {
        // Використання Builder для створення комп'ютера
        Computer computer1 =
                new Computer.Builder("Intel Core i7", 16, 512, "NVIDIA GTX 4070", true)
                .build();

        System.out.println("Computer 1:");
        System.out.println(computer1);

        Computer computer2 =
                new Computer.Builder("AMD Ryzen 7", 32, 768, "AMD Radeon RX 8900", false)
                        .build();

        System.out.println("\nComputer 2:");
        System.out.println(computer2);
    }
}
