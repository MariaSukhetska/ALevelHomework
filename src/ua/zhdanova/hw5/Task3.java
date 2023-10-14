package ua.zhdanova.hw5;
public class Task3 {
        public static void main(String[] args) {
            int[][] originalArray = {
                    {1, 2},
                    {3, 4}
            };

            printArray("Original array:", originalArray);

            int[][] transposedArray = transposeArray(originalArray);

            printArray("Changed array:", transposedArray);
        }

        public static int[][] transposeArray(int[][] array) {
            int[][] newArray = new int[array[0].length][array.length];

            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    newArray[j][i] = array[i][j];
                }
            }
            return newArray;
        }

        public static void printArray(String message, int[][] array) {
            System.out.println(message);
            for (int[] ints : array) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }

