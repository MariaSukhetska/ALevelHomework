package ua.zhdanova.hw4;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] number = generateArray(1000);
        int primeCount = countPrimes(number);
        System.out.println("Кількість простих чисел: " + primeCount);
    }
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt();
        }
        return array;
    }
    public static int countPrimes(int[] array) {
        int count = 0;
        for (int num : array) {
            if (isPrime(num)) {
                count++;
            }
        }
        return count;
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        int i = 5;
        while (i * i <= num) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
            i += 6;
        }
        return true;
    }
}