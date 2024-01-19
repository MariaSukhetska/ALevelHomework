package ua.zhdanova.hw21.static_factory;

public class Product {
    private String name;
    private double price;
    private String category;

    private Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Product of(String name, double price, String category) {
        validateInput(name, price);
        return new Product(name, price, category);
    }

    public static Product basicOf(String name, double price) {
        validateInput(name, price);
        return new Product(name, price, "Uncategorized");
    }

    private static void validateInput(String name, double price) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty or null");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Price must be a positive value");
        }
    }

    @Override
    public String toString() {
        return "Product{"
                + "name='" + name + '\''
                + ", price=" + price
                + ", category='" + category + '\''
                + '}';
    }
}
