package by.tms.hibernate.dao;

import by.tms.hibernate.entity.User;
import by.tms.hibernate.sessionfactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class UserDao {

    public void saveFromDB(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(user);
        transaction.commit();
        session.close();
    }

    public void updateFromDB(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(user);
        transaction.commit();
        session.close();
    }

    public void deleteFromDB(User user) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(user);
        transaction.commit();
        session.close();
    }

    public User findByIdFromDB(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(User.class, id);
    }

    public List<User> findAllFromDB() {
        List<User> users = (List<User>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From User").list();
        return users;
    }

}
