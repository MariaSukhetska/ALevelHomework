package ua.zhdanova.hw11;

import ua.zhdanova.hw11.Figure;

class Square extends Figure {
    private double side;
    public Square(double side) {
        try {
            if (side < 0) {
                throw new InvalidDataException("Side of square need to be positive number");
            }
            this.side = side;
        } catch (InvalidDataException exception) {
            System.out.println("InvalidDataException exception: " + exception.getMessage());
        }
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
