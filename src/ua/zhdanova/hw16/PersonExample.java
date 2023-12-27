package ua.zhdanova.hw16;

import java.lang.reflect.Field;
public class PersonExample {
    public static void main(String[] args) {
        PersonExample personExample = new PersonExample();
        Person person = personExample.createPerson("John Doe", 25, "123 Main St");
        // Виведення інформації про об'єкт Person з використанням рефлексії
        personExample.printFields(person);
    }
    private Person createPerson(String name, int age, String address) {
        return new Person(name, age, address);
    }
    private void printFields(Person person) {
        Class<?> personClass = person.getClass();
        Field[] fields = personClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true); // Робимо приватні поля доступними
            String fieldName = field.getName();
            try {
                Object value = field.get(person);
                System.out.println(fieldName + ": " + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
