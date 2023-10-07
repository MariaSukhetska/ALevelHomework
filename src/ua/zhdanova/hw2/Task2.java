package ua.zhdanova.hw2;

public class Task2 {
    public static void main(String[] args) {
        int number = 7;
        boolean isNumberEven = isEven( number );
        System.out.println(isNumberEven);
    }
    public static boolean isEven (int number) {
        return number % 2 == 0;
    }
}