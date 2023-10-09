package ua.zhdanova.hw2;

public class Task3_2  {
    public static void main(String[] args) {
        int num1 = -8;
        int num2 = 5;
        int num3 = 9;
        int minNumber = findMin(num1, num2, num3);
        int minAbsNumber = findMinAbs(num1, num2, num3);
        System.out.println(minNumber);
        System.out.println(minAbsNumber);
    }

    public static int findMin(int num1, int num2, int num3) {
        return (num1 < num2 ? (num1 < num3 ? num1 : num3) : (num2 < num3 ? num2 : num3));
    }
    public static int findMinAbs(int num1, int num2, int num3) {
        int abs1 = Math.abs(num1);
        int abs2 = Math.abs(num2);
        int abs3 = Math.abs(num3);
        return (abs1 < abs2) ? (abs1 < abs3 ? abs1 : abs3) : (abs2 < abs3 ? abs2 : abs3);
    }
}