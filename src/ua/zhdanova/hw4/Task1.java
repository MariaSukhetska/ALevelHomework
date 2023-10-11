package ua.zhdanova.hw4;
import java.util.Random;

public class Task1 {

    public static void main(String[] args) {
        int[] originalArray = generateRandomArray(400);
        System.out.println("Среднє арифметичне: " + average(originalArray));
        System.out.println("Среднє геометричне: " + geometricMean(originalArray));
    }

    public static int[] generateRandomArray(int size) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(10) + 1;
        }
        return array;
    }

    public static double average(int[] originalArray) {
        int[] arrayCopy = originalArray.clone();
        int sum = 0;
        for (int value : arrayCopy) {
            sum += value;
        }
        return (double) sum / arrayCopy.length;
    }

    public static double geometricMean(int[] originalArray) {
        int[] arrayCopy = originalArray.clone();
        double product = 1.0;
        for (int value : arrayCopy) {
            product *= value;
        }
        return Math.pow(product, 1.0 / arrayCopy.length);
    }
}
