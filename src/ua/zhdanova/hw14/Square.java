package ua.zhdanova.hw14;

class Square extends Figure {
    private double side;

    @Override
    public String toString() {
        return Double.toString(area());
    }

    public Square(double side) {
        this.side = side;
    }

    @Override
    public double perimeter() {

        return 4 * side;
    }

    @Override
    public double area() {
        return side * side;
    }
}
