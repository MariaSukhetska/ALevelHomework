package ua.zhdanova.hw19;

import com.fasterxml.jackson.annotation.JsonProperty;

public class People {
    @JsonProperty("name")
    private String name;
    @JsonProperty("age")
    private int age;

    public People() {
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "People{"
                + "name='" + name + '\''
                + ", age=" + age
                + '}';
    }
}
