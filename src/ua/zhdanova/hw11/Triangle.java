package ua.zhdanova.hw11;

import ua.zhdanova.hw11.Figure;

class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private double base;
    private double height;
    private double angleInDegrees;

    public Triangle(double sideA, double sideB, double sideC, double base, double height, double angleInDegrees) {
        try {
            if (sideA < 0 || sideB < 0 || sideC < 0 || base < 0 || height < 0 || angleInDegrees < 0) {
                throw new
                        InvalidDataException("Sides of triangle need to be positive number");
            }
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = sideC;
            this.base = base;
            this.height = height;
            this.angleInDegrees = angleInDegrees;
        } catch (InvalidDataException exception) {
            System.out.println("InvalidDataException exception: " + exception.getMessage());
        }
    }

    @Override
    public double perimeter() {

        return sideA + sideB + sideC;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    public double areaWithSinFormula() {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return 0.5 * sideA * sideB * Math.sin(angleInRadians);
    }

    public double areaWithBaseHeight() {
        return 0.5 * base * height;
    }
}
