package ua.zhdanova.hw10;

class Triangle extends Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private double base;
    private double height;
    private double angleInDegrees;

    public Triangle(double sideA, double sideB, double sideC, double base, double height, double angleInDegrees) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        this.base = base;
        this.height = height;
        this.angleInDegrees = angleInDegrees;
    }

    @Override
    public double perimeter() {

        return this.sideA + this.sideB + this.sideC;
    }

    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s * (s - this.sideA) * (s - this.sideB) * (s - this.sideC));
    }

    public double area(double sideA, double sideB, double angleInDegrees) {
        double angleInRadians = Math.toRadians(angleInDegrees);
        return 0.5 * this.sideA * this.sideB * Math.sin(angleInRadians);
    }

    public double area(double base, double height) {
        return 0.5 * this.base * this.height;
    }
}



