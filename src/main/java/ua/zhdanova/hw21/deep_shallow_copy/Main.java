package ua.zhdanova.hw21.deep_shallow_copy;

public class Main {
    public static void main(String[] args) {

        Address originalAddress = new Address("Arizona", "Lincoln str", 100000);
        Person originalPerson = new Person("Jane", "Zhdanova", "Main str 123", 25, originalAddress);

        System.out.println("Original:");
        originalPerson.displayInfo();

        try {

            Person clonedPerson = originalPerson.deepCopy();

            clonedPerson.setFirstName("Mariya");
            clonedPerson.getAddress().setCity("New York");

            System.out.println("\nCloned:");
            clonedPerson.displayInfo();

            System.out.println("\nOriginal (unchanged):");
            originalPerson.displayInfo();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Can't create clone Object", e);
        }
    }
}
