package ua.zhdanova.hw3;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рядок:");
        String input = scanner.nextLine();
        String stringWithoutSpaces = removeSpaces(input);
        boolean isPalindrome = isPalindrome(stringWithoutSpaces);
        if (isPalindrome) {
            System.out.println("Рядок є паліндромом.");
        } else {
            System.out.println("рядок не є паліндромом.");
        }
    }
    public static String removeSpaces(String str) {
        return str.replaceAll("\\s+", "");
    }
    public static boolean isPalindrome(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}