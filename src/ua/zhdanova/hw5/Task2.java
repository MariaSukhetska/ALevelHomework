package ua.zhdanova.hw5;
public class Task2 {

    public static void main(String[] args) {
        int[] array = {5, 3, 2, 1};

        // А) Виводимо масив до операцій
        printArray("Original array:", array);

        // Б) Результат перевірки виводимо в консоль в методі main().
        System.out.println(" Чи масив відсортований за спаданням ? " + isSortedDescending(array));
    }

    // Виводимо масив в консоль
    public static void printArray(String message, int[] array) {
        System.out.print(message + " ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Перевіряємо, чи впорядкований масив за спаданням
    public static boolean isSortedDescending(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i-1]) {
                return false;
            }
        }
        return true;
    }
}