package by.tms.hibernate.dao;

import by.tms.hibernate.entity.Operation;
import by.tms.hibernate.sessionfactory.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.List;

public class OperationDao {

    public void saveFromDB(Operation operation) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(operation);
        transaction.commit();
        session.close();
    }

    public void updateFromDB(Operation operation) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(operation);
        transaction.commit();
        session.close();
    }

    public void deleteFromDB(Operation operation) {
        Session session = HibernateSessionFactory.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(operation);
        transaction.commit();
        session.close();
    }

    public Operation findByIdFromDB(int id) {
        return HibernateSessionFactory.getSessionFactory().openSession().get(Operation.class, id);
    }

    public List<Operation> findAllFromDB() {
        List<Operation> operations = (List<Operation>) HibernateSessionFactory.getSessionFactory().openSession().createQuery("From User").list();
        return operations;
    }

}
