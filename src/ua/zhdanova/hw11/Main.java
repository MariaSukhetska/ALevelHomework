package ua.zhdanova.hw11;

import ua.zhdanova.hw11.Circle;
import ua.zhdanova.hw11.Figure;
import ua.zhdanova.hw11.Square;
import ua.zhdanova.hw11.Triangle;
public class Main {
    public static void main(String[] args) {
        try {
            ua.zhdanova.hw11.Circle circle = new Circle(7);
            ua.zhdanova.hw11.Square square = new ua.zhdanova.hw11.Square(-5);
            ua.zhdanova.hw11.Triangle triangle = new ua.zhdanova.hw11.Triangle(-6, -5, 2, 6, 1.561249499599599, 18.195);
            ua.zhdanova.hw11.Figure[] figures = {circle, square, triangle};
            for (ua.zhdanova.hw11.Figure figure : figures) {
                System.out.println(figure.getClass().getSimpleName() + " perimeter = " + figure.perimeter() + ", " + figure.getClass().getSimpleName() + " area = " + figure.area());
            }
            System.out.println();
            double maxArea = 0;
            String figureWithMaxArea = "";
            for (Figure figure : figures) {
                if (figure.area() > maxArea) {
                    maxArea = figure.area();
                    figureWithMaxArea = figure.getClass().getSimpleName();
                }
            }
            System.out.println("Figure with the biggest area is " + figureWithMaxArea + " with an area of " + maxArea);
        } catch (IllegalArgumentException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}

