package ua.zhdanova.hw5;

public class Task1 {
    public static void main(String[] args) {
        int[][] array = new int[4][3];
        fillArray(array);
    }

    public static void fillArray(int[][] array) {
        int k = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = k + 1;
                k++;
                if (i % 2 != 0) {
                    array[i][j] = -1 * array[i][j];
                }
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}