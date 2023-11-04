package ua.zhdanova.hw10;


public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(7);
        Square square = new Square(5);
        Triangle triangle = new Triangle(6, 5, 2, 6, 1.561249499599599, 18.195);

        System.out.println("Circle perimeter = " + circle.perimeter() + ", Circle area = " + circle.area());
        System.out.println("Square perimeter = " + square.perimeter() + ", Square area = " + square.area());
        System.out.println("Triangle perimeter = " + triangle.perimeter() + ", Triangle area = " + triangle.area());

        System.out.println();
        double areaOfTriangleWithHeronFormula = triangle.area();
        System.out.println("Area of triangle with Heron formula = " + areaOfTriangleWithHeronFormula);
        double areaOfTriangleWithBaseHeight = triangle.areaWithBaseHeight();
        System.out.println("Area of triangle with Base Height = " + areaOfTriangleWithBaseHeight);
        double areaWithSinFormula = triangle.areaWithSinFormula();
        System.out.println("Area of triangle with Sin Formula = " + areaWithSinFormula);

        System.out.println();
        findFigureWithBiggestArea(circle, square, triangle);
    }

    private static void findFigureWithBiggestArea(Circle circle, Square square, Triangle triangle) {
        if (circle.area() > square.area() && circle.area() > triangle.area()) {
            System.out.println("Area for circle is the biggest (" + circle.area() + ")");
        } else if (square.area() > triangle.area()) {
            System.out.println("Area for square is the biggest (" + square.area() + ")");
        } else {
            System.out.println("Area for triangle is the biggest (" + triangle.area() + ")");


        }
    }
}
