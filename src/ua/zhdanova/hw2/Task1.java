package ua.zhdanova.hw2;

public class Task1 {
    public static void main(String[] args) {
        int x1 = 1, y1 = 5;
        int x2 = 3, y2 = 5;
        int x3 = 6, y3 = 7;
        double square = 0.5 *  Math.abs ( ( x1 *( y2 -y3 ) + x2 *( y3 -y1 ) + x3 *( y1 -y2 ) ) );
        System.out.println ( square );
    }
}
