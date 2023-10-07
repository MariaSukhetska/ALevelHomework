package ua.zhdanova.hw2;

public class Task3_2 {
    public static void main(String[] args) {
        int num1 = 8;
        int num2 = 5;
        int num3 = 9;
        int min1 = num1 < num2 ? (num1 < num3 ? num1 : num3) : ( num2 < num3 ? num2 : num3);
        System.out.println(min1);
        int min2 = (num2 % num1 < num3 % num1) ? (num2 % num1 < num3 % num2 ? num2 % num1 : num3 % num2) : (num3 % num1 < num3 % num2 ? num3 % num1 : num3 % num2);
        System.out.println(min2);
    }
}