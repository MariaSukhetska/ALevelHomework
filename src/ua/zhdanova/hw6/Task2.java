/* Помилка на рядку No25, знайшла встановивши точку breikpoint і запустивши програму в режимі Debug,виконання зупинилося
в моїй точці.Нажавши кнопку Step Over, пройшла крок за кроком проходити через код,продивляючи значення змінних.Помітила,
що у одному з циклів змінна j не змінилась. Подивилась на умову циклу і зрозуміла, що використовується не правильний
індекс для порівняння. Встановши точку на цьому рядку, я побачила що виконання не йде так як цього очікувала. Змінила
індекс з i на j, знову запустила Debug і побачила що проблема виправлена.*/

package ua.zhdanova.hw6;
public class Task2 {
    public static void main(String[] args) {
        int[][] triangle = new int[5][];
        triangle[0] = new int[1];
        triangle[1] = new int[2];
        triangle[2] = new int[3];
        triangle[3] = new int[4];
        triangle[4] = new int[5];
        for (int i = 0; i < triangle.length; i++) {
            System.out.println(triangle.length + "!");
            System.out.println("i = " + i);
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.println(triangle[i].length);
                triangle[i][j] = 0;
            }
        }
        for (int i = 0; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                System.out.print(triangle[i][j] + " ");
            }
            System.out.println();
        }
    }
}