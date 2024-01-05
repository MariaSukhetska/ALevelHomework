package ua.zhdanova.hw10;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Square square = new Square(5);
        Triangle triangle = new Triangle(6, 5, 2, 6, 1.561249499599599, 18.195);
        Figure[] figures = {circle, square, triangle};
        for (Figure figure : figures) {
            System.out.println(figure.getClass().getSimpleName() + " perimter = " + figure.perimeter() + ", " + figure.getClass().getSimpleName() + " area = " + figure.area());
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
    }
}
