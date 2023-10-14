package ua.zhdanova.hw5;
public class Task2 {

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1};

        printArray("Original array:", array);

        System.out.println(" Чи масив відсортований за спаданням ? " + isSortedDescending(array));
    }

    public static void printArray(String message, int[] array) {
        System.out.print(message + " ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static boolean isSortedDescending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                return false;
            }
        }
        return true;
    }
}