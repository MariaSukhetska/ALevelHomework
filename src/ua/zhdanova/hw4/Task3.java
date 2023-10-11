package ua.zhdanova.hw4;
import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int[] originalArray = generateArray(2000);
        int[] modifiedArray = replaceEvenWithZeros(originalArray);
        printArray(originalArray);
        printArray(modifiedArray);
    }
    public static int[] generateArray(int size) {
        int[] array = new int[size];
        Random generator = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = generator.nextInt(2000);
        }
        return array;
    }
    public static int[] replaceEvenWithZeros(int[] array) {
        int[] arrayCopy = array.clone();
        for (int i = 0; i < arrayCopy.length; i++) {
            if (arrayCopy[i] % 2 == 0) {
                arrayCopy[i] = 0;
            }
        }
        return arrayCopy;
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
