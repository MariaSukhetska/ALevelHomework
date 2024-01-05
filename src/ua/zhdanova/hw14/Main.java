package ua.zhdanova.hw14;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<>(List.of(
                new Circle(4),
                new Circle(9),
                new Square(8),
                new Square(2),
                new Triangle(6.0, 5.0, 2.0, 6.0, 1.561249499599599, 18.195)
        ));
        double difference = 13.0;
        Figure result1 = findFigure(figures, difference);
        if (result1 != null) {
            System.out.println("Фігура, площа якої більша за мінімальну при " + difference + ": " + result1);
        } else {
            System.out.println("\n" +
                    "Не знайдено фігур, площа яких перевищує мінімальну в " + difference);
        }
        List<Figure> result2 = findFigures(figures);
        if (!result2.isEmpty()) {
            System.out.println("\nФігури, площа яких у два рази більша за периметр: " + result2);
        } else {
            System.out.println("Не знайдено фігур, площа яких у два рази перевищує периметр");
        }
    }
    private static Figure findFigure(List<Figure> figures, double difference) {
        return figures.stream()
                .filter(figure -> figure.area() == findMinArea(figures) + difference)
                .findFirst()
                .orElse(null);
    }
    private static double findMinArea(List<Figure> figures) {
        return figures.stream()
                .mapToDouble(Figure::area)
                .min()
                .orElse(0.0);
    }
    private static List<Figure> findFigures(List<Figure> figures) {
        return figures.stream()
                .filter(figure -> figure.area() == 2 * figure.perimeter())
                .collect(Collectors.toList());
    }
}
