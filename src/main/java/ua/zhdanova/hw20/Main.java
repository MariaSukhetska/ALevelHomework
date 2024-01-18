package ua.zhdanova.hw20;

import ua.zhdanova.hw20.dao.Dao;
import ua.zhdanova.hw20.dao.HibernatePersonDao;
import ua.zhdanova.hw20.dao.JdbcPersonDao;
import ua.zhdanova.hw20.model.Person;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // HibernatePersonDao example
            Dao<Person> hibernatePersonDao = new HibernatePersonDao();

            Person person3 = new Person();
            person3.setId(3L);
            person3.setFirstName("Steve");
            person3.setLastName("Jobs");
            person3.setLivingAddress("78910 Elm St");

            hibernatePersonDao.add(person3);

            List<Person> hibernatePersons = hibernatePersonDao.getAll();
            System.out.println("Persons retrieved using Hibernate:");
            for (Person person : hibernatePersons) {
                System.out.println(person);
            }

            person3.setLivingAddress("UpdatedLivingAddress");
            hibernatePersonDao.update(person3);

            hibernatePersons = hibernatePersonDao.getAll();
            System.out.println("Persons after update using Hibernate:");
            for (Person person : hibernatePersons) {
                System.out.println(person);
            }

            hibernatePersonDao.delete(person3);

            hibernatePersons = hibernatePersonDao.getAll();
            System.out.println("Persons after delete using Hibernate:");
            for (Person person : hibernatePersons) {
                System.out.println(person);
            }

            // JdbcPersonDao example
            Dao<Person> jdbcPersonDao = new JdbcPersonDao();

            Person person1 = new Person();
            person1.setId(1L);
            person1.setFirstName("Maria");
            person1.setLastName("Zhdanova");
            person1.setLivingAddress("123 Main St");
            Person person2 = new Person();
            person2.setId(2L);
            person2.setFirstName("Jane");
            person2.setLastName("Smith");
            person2.setLivingAddress("4567 Oak St");

            jdbcPersonDao.add(person1);
            jdbcPersonDao.add(person2);

            List<Person> jdbcPersons = jdbcPersonDao.getAll();
            System.out.println("Persons retrieved using JDBC:");
            for (Person person : jdbcPersons) {
                System.out.println(person);
            }

            person1.setLastName("Mari");
            jdbcPersonDao.update(person1);

            jdbcPersons = jdbcPersonDao.getAll();
            System.out.println("Persons after update using JDBC:");
            for (Person person : jdbcPersons) {
                System.out.println(person);
            }

            jdbcPersonDao.delete(person2);

            jdbcPersons = jdbcPersonDao.getAll();
            System.out.println("Persons after delete using JDBC:");
            for (Person person : jdbcPersons) {
                System.out.println(person);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error during process data: ");
        }
    }
}
