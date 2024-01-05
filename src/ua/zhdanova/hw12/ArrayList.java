package ua.zhdanova.hw12;
import java.util.Arrays;
public class ArrayList<T> {
    private Object[] array;
    private int size;
    private int count = 0;

    ArrayList(int size) {
        this.size = size;
        array = new Object[size];
    }

    //Add element to the end of array {1,2,3} -> {1,2,3,4}
    void add(T element) {

        if (count < size) {
            array[count++] = element;
        } else {
            Object[] newArray = array;
            array = Arrays.copyOf(newArray, newArray.length + 1);
            array[count++] = element;
        }
    }

    //Add element to given position of array {1,2,3} -> {1,4,2,3}
    void add(T element, int index) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        Object[] newArray = array;
        array = new Object[newArray.length + 1];
        for (int i = 0; i < index; i++) {
            array[i] = newArray[i];
        }
        array[index] = element;
        for (int i = index + 1; i < array.length; i++) {
            array[i] = newArray[i - 1];
        }
    }
    //Returns index of the given element, if element doesn't exist return -1
    int indexOf(T element) {
        int index = -1;
        for (int i = 0; i < array.length; i++) {
            if (element == array[i]) {
                index = i;
                break;
            }
        }
        return index;
    }
    boolean isContains(T element) {
        return indexOf(element) != -1;
    }
    T get(int index) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        return (T) array[index];
    }
    Object[] remove(int index) {
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        Object[] newArray = array;
        array = new Object[newArray.length - 1];
        for (int i = 0; i < newArray.length - 1; i++) {
            if (i < index) {
                array[i] = newArray[i];
            } else array[i] = newArray[i + 1];
        }
        return array;
    }
    void print() {
        for (Object o : array) {
            System.out.println(o);
        }
    }
}