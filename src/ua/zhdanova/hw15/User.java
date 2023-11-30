package ua.zhdanova.hw15;

class User {
    String name;
    String secondName;
    int salary;
    int age;

    public User(String name, String secondName, int salary, int age) {
        this.name = name;
        this.secondName = secondName;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSecondName() {
        return secondName;
    }
    public int getSalary() {
        return salary;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + "', secondName='" + secondName + "', salary=" + salary + ", age=" + age + '}';
    }
}