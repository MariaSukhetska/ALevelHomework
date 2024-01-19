package ua.zhdanova.hw21.deep_shallow_copy;

import java.util.Objects;

public class Person implements Cloneable {
    private String firstName;

    private String lastName;

    private String livingAddress;

    private int age;

    private Address address;

    public Person(String firstName, String lastName, String livingAddress, int age, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.livingAddress = livingAddress;
        this.age = age;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(firstName, person.firstName)
                && Objects.equals(lastName, person.lastName) && Objects.equals(livingAddress, person.livingAddress)
                && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, livingAddress, age, address);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", livingAddress='" + livingAddress + '\''
                + ", age=" + age
                + ", address=" + address
                + '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person clonedPerson = (Person) super.clone();
        clonedPerson.address = (Address) address.deepCopy();
        return clonedPerson;
    }

    public Person deepCopy() throws CloneNotSupportedException {
        return (Person) clone();
    }

    public void displayInfo() {
        System.out.println("Person: " + toString());
    }
}
