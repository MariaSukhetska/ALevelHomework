package ua.zhdanova.hw5;
import java.util.Arrays;

public class Task1_2 {
    public static void main(String[] args) {
        int[][] array = new int[4][3];
        fillArray(array);

        System.out.println("Original array:");
        printArray(array);

        int[][] UpdateArray = plusMinusArray(array);

        System.out.println("Update array:");
        printArray(UpdateArray);
    }

    public static void fillArray(int[][] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = k + 1;
                k++;
            }
        }
    }

    public static void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    public static int[][] plusMinusArray(int[][] array) {
        int[][] newArray = new int[array.length][];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = Arrays.copyOf(array[i], array[i].length);
            for (int j = 0; j < newArray[i].length; j++) {
                if (i % 2 != 0) {
                    newArray[i][j] = -1 * newArray[i][j];
                }
            }
        }
        return newArray;
    }
}