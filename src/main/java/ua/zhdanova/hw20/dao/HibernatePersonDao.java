package ua.zhdanova.hw20.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.zhdanova.hw20.exception.DataProcessingException;
import ua.zhdanova.hw20.model.Person;
import ua.zhdanova.hw20.util.HibernateUtil;
import java.util.List;

public class HibernatePersonDao implements Dao<Person> {
    @Override
    public Person getById(Long id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.get(Person.class, id);
        } catch (Exception e) {
            throw new DataProcessingException("Can't getting Person by ID: " + id, e);
        }
    }

    @Override
    public List<Person> getAll() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("FROM Person", Person.class).list();
        } catch (Exception e) {
            throw new DataProcessingException("Can't get all Person's: ", e);
        }
    }

    @Override
    public Person add(Person entity) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't adding person into DB: " + entity, e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public void update(Person entity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't updating current person: " + entity, e);
        }
    }

    @Override
    public void delete(Person entity) {
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            throw new DataProcessingException("Can't delete current person: " + entity, e);
        }
    }
}
