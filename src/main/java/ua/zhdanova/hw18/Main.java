package ua.zhdanova.hw18;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("NameUser");
        try (emf; EntityManager em = emf.createEntityManager()) {
            addUser(em);
            User user = readUserById(em, 1L);
            System.out.println("Read user: " + user);
            user.setUsername("UpdatedUsername");
            updateUser(em, user);
            deleteUser(em, user);
            User newUser = createUserWithOrders(em);
            readUserAndOrders(em, newUser.getId());

            Date startDate = new Date(); // Поточна дата
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDate);
            calendar.add(Calendar.DAY_OF_MONTH, 7); // Додаємо 7 днів до поточної дати
            Date endDate = calendar.getTime();

            // Викликаємо методи для завдань 4 та 5:
            selectUsersWithMoreThanFiveOrders(em);
            selectOrdersByUserAndPeriod(em, newUser.getId(), startDate, endDate);
            countOrdersPerUser(em);
        }
    }
    private static void addUser(EntityManager em) {

        EntityTransaction transaction = null;

        try {

            transaction = em.getTransaction();

            transaction.begin();

            User user = new User();

            user.setUsername("Maria Zhdanova");

            em.persist(user);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            throw new RuntimeException("Can't insert User to DB" + e);
        }
    }

    private static User readUserById(EntityManager em, Long userId) {

        return em.find(User.class, userId);

    }

    private static void updateUser(EntityManager em, User user) {

        EntityTransaction transaction = null;

        try {

            transaction = em.getTransaction();

            transaction.begin();

            em.merge(user);

            transaction.commit();

        } catch (Exception e) {

            if (transaction != null) {

                transaction.rollback();

            }

            throw new RuntimeException("Can't update User into DB" + e);
        }

    }

    private static void deleteUser(EntityManager em, User user) {

        EntityTransaction transaction = null;

        try {

            transaction = em.getTransaction();

            transaction.begin();

            em.remove(user);

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }

            throw new RuntimeException("Can't delete User from DB" + e);
        }
    }

    private static User createUserWithOrders(EntityManager em) {

        EntityTransaction transaction = null;

        try {

            transaction = em.getTransaction();

            transaction.begin();

            User user = new User();

            user.setUsername("Alessia Mazzoleni");

            Order order1 = new Order();

            order1.setOrderDetails("Buy Play Station5");
            order1.setOrderDate(new Date());

            order1.setUser(user);

            Order order2 = new Order();

            order2.setOrderDetails("Buy iPhone 15 Pro Max");
            order2.setOrderDate(new Date());

            order2.setUser(user);

            user.setOrders(List.of(order1, order2));

            em.persist(user);

            transaction.commit();

            return user;

        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new RuntimeException("Can't add user to the DB" + e);
        }
    }

    private static void readUserAndOrders(EntityManager em, Long userId) {

        User user = em.find(User.class, userId);

        System.out.println("User: " + user);

        List<Order> orders = user.getOrders();

        System.out.println("Orders: " + orders);
    }

    private static void selectUsersWithMoreThanFiveOrders(EntityManager em) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE SIZE(u.orders) > 5", User.class).getResultList();
        System.out.println("Users with more than 5 orders: " + users);
    }

    private static void selectOrdersByUserAndPeriod(EntityManager em, Long userId, Date startDate, Date endDate) {
        List<Order> orders = em.createQuery("SELECT o FROM Order o WHERE o.user.id " +
                        "= :userId AND o.orderDate BETWEEN :startDate AND :endDate", Order.class)
                .setParameter("userId", userId)
                .setParameter("startDate", startDate)
                .setParameter("endDate", endDate)
                .getResultList();
        System.out.println("Orders made by user within the specified period: " + orders);
    }

    private static void countOrdersPerUser(EntityManager em) {
        List<Object[]> results = em.createQuery("SELECT u.username, COUNT(o) " +
                        "FROM User u LEFT JOIN u.orders o GROUP BY u.id, u.username", Object[].class)
                .getResultList();

        System.out.println("Total orders per user:");
        for (Object[] result : results) {
            System.out.println("User: " + result[0] + ", Total Orders: " + result[1]);
        }
    }
}