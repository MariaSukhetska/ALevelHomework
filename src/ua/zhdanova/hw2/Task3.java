package ua.zhdanova.hw2;

public class Task3 {
    public static void main(String[] args) {
        int num1 = 8;
        int num2 = 5;
        int num3 = 9;
        System.out.println(Math.min(num1, Math.min(num2, num3)));
        System.out.println(Math.min(num2%num1, Math.min(num3%num1, num3%num2)));
    }
}
