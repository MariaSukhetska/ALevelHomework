package ua.zhdanova.hw11;

public class Circle extends Figure {
    private double radius;

    public Circle(double radius) {
        try {
            if (radius < 0) {
                throw new InvalidDataException("Radius of circle need to be positive number");
            }
            this.radius = radius;
        } catch (InvalidDataException exception) {
            System.out.println("InvalidDataException exception: " + exception.getMessage());
        }
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


