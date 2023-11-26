package ua.zhdanova.hw10;

public class Circle extends Figure {
    private double radius;

    @Override
    public String toString() {
        return Double.toString(area());
    }

    public Circle(double radius) {

        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double area() {

        return Math.PI * radius * radius;
    }
}