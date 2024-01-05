package ua.zhdanova.hw9;

public class MyClass {
    private int number;
    private String name;

    public MyClass(int number, String name) {
        this.number = number;
        this.name = name;
    }

    public void displayVariables() {
        System.out.println("number: " + number);
        System.out.println("name: " + name);
    }
    public int getNumber() {
        return number;
    }
    public String getName() {
        return name;
    }
}