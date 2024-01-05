package ua.zhdanova.hw9;

public class Peat {
    private String name;
    private int hoursOfSleeping;
    private String food;
    public Peat(String name, int hoursOfSleeping, String food) {
        this.name = name;
        this.hoursOfSleeping = hoursOfSleeping;
        this.food = food;
    }
    public int getHoursOfSleeping() {
        return hoursOfSleeping;
    }
    public String getFood() {
        return food;
    }
    public String getName() {
        return name;
    }
}
