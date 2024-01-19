package ua.zhdanova.hw21.static_factory;
public class Main {
    public static void main(String[] args) {
        Product laptop = Product.of("Laptop", 2500.99, "NoteBooks");
        Product book = Product.basicOf("Book", 29.99);
        Product smartphone = Product.of("Smartphone", 1299.99, "SmartPhones");
        Product chair = Product.of("Office Chair", 149.99, "Furniture");

        System.out.println("Product 1: " + laptop);
        System.out.println("Product 2: " + book);
        System.out.println("Product 3: " + smartphone);
        System.out.println("Product 4: " + chair);
    }
}
