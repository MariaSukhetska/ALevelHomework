package ua.zhdanova.hw10;

class Square extends Figure {
    private double side;

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
