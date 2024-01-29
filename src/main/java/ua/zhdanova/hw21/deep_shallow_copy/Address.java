package ua.zhdanova.hw21.deep_shallow_copy;

import java.util.Objects;

public class Address implements Cloneable {
    private String city;
    private String street;
    private int population;

    public Address(String city, String street, int population) {
        this.city = city;
        this.street = street;
        this.population = population;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return population == address.population
                && Objects.equals(city, address.city) && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, population);
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", population=" + population +
                '}';
    }

    @Override
    protected Object clone() {
        try {
            Address clonedAddress = (Address) super.clone();
            return clonedAddress;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

