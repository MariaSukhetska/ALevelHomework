package ua.zhdanova.module2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        File inputFile = new File("D:\\HomeworkALevel\\Homework_3\\src\\ua\\zhdanova\\module2\\Text");
        File outputFile = new File("D:\\HomeworkALevel\\Homework_3\\src\\ua\\zhdanova\\module2\\Text1");
        List<Product> productList = readProductsFromFile(inputFile);
        // 1. Відфльтрувати продукти з кількістю більше заданого значення
        int filterQuantity = 4;
        List<Product> filteredProducts = filterProductsByQuantity(productList, filterQuantity);
        // 2. Підрахувати загальну кількість продуктів в холодильнику
        int totalQuantity = calculateTotalQuantity(productList);
        // 3. Знайти средню ціну продуктів
        double averagePrice = calculateAveragePrice(productList);
        // 4. Відсортувати продукти по ціні в порядку спадання
        List<Product> sortedProducts = sortProductsByPriceDescending(productList);
        // 5. Підрахувати загальну вартість продуктів (ціна * кількість)
        double totalCost = calculateTotalCost(productList);
        writeResultsToFile(outputFile, filteredProducts, totalQuantity, averagePrice, sortedProducts, totalCost);
    }
    private static List<Product> readProductsFromFile(File file) {
        List<Product> productList = new ArrayList<>();
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split("\\|");
                String name = parts[0].trim();
                int quantity = Integer.parseInt(parts[1].trim());
                double price = Double.parseDouble(parts[2].trim());
                Product product = new Product(name, quantity, price);
                productList.add(product);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read data from file: " + e);
        }
        return productList;
    }
    private static List<Product> filterProductsByQuantity(List<Product> productList, int filterQuantity) {
        return productList.stream()
                .filter(product -> product.getQuantity() > filterQuantity)
                .collect(Collectors.toList());
    }
    private static int calculateTotalQuantity(List<Product> productList) {
        return productList.stream()
                .mapToInt(Product::getQuantity)
                .sum();
    }
    private static double calculateAveragePrice(List<Product> productList) {
        double totalCost = calculateTotalCost(productList);
        int totalQuantity = calculateTotalQuantity(productList);
        if (totalQuantity == 0) {
            return 0.0;
        }
        double averagePrice = totalCost / totalQuantity;
        return Math.round(averagePrice * 100.0) / 100.0;
    }
    private static List<Product> sortProductsByPriceDescending(List<Product> productList) {
        return productList.stream()
                .sorted(Comparator.comparingDouble(Product::getTotalCost).reversed())
                .collect(Collectors.toList());
    }
    private static double calculateTotalCost(List<Product> productList) {
        return productList.stream()
                .mapToDouble(Product::getTotalCost)
                .sum();
    }
    private static void writeResultsToFile(File file, List<Product> filteredProducts, int totalQuantity,
                                           double averagePrice, List<Product> sortedProducts, double totalCost) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("1. Filtered Products:\n");
            filteredProducts.forEach(product -> writeProductToFile(writer, product));
            writer.write("\n2. Total Quantity of all Products: " + totalQuantity + "\n");
            writer.write("\n3. Average Price of all Products: " + averagePrice + "\n");
            writer.write("\n4. Sorted Products by Price (Descending):\n");
            sortedProducts.forEach(product -> writeProductToFile(writer, product));
            writer.write("\n5. Total Cost of all Products: " + totalCost + "\n");
        } catch (IOException e) {
            throw new RuntimeException("Can't write results to file: " + e);
        }
    }
    private static void writeProductToFile(FileWriter writer, Product product) {
        try {
            writer.write(product.getName() + " | Quantity: " + product.getQuantity() + " | Price: " + product.getPrice() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}