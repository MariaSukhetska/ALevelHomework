package ua.zhdanova.hw2;

import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть число:");

        String input = scanner.nextLine();
        String reversed = reverse(input);

        System.out.println("Обернене число: " + reversed);
    }

    public static String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}