package ua.zhdanova.hw12;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        int initialSize = 2;
        ArrayList<Integer> array = new ArrayList<>(initialSize);
        array.add(5);
        array.add(6);
        array.add(4);
        array.add(4);
        array.print();
        System.out.println("Index of element: " + array.indexOf(4));
        array.add(3, 2);
        array.add(1, 2);
        array.add(0, 4);
        System.out.println("Array with an added element:");
        array.print();

        System.out.println("Is this element included in the Array? " + array.isContains(5));
        System.out.println("Third element for Array: " + array.get(3));
        array.remove(1);
       array.print();
   }
}
