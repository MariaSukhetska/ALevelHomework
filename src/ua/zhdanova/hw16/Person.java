package ua.zhdanova.hw16;


import java.lang.reflect.Field;
class Person {
    private String name;
    private int age;
    private String address;
    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
class PersonFactory {
    public Person createPerson(String name, int age, String address) {
        return new Person(name, age, address);
    }
    public void printFields(Object obj) {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Make private fields accessible
            String fieldName = field.getName();
            try {
                Object value = field.get(obj);
                System.out.println(fieldName + ": " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
